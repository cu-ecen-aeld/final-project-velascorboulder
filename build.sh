#!/bin/bash
# Script to build image for qemu.
# Author: Siddhant Jajoo.

git submodule init
git submodule sync
git submodule update

# local.conf won't exist until this step on first execution
source poky/oe-init-build-env


LICENSEFLAGLINE='LICENSE_FLAGS_ACCEPTED = "synaptics-killswitch"'

# Specify the file where the replacement should occur
FILE="conf/local.conf"

# Define the search pattern and the replacement lines
SEARCH_PATTERN='^MACHINE ='
QEMU_LINE='MACHINE = "qemuarm64"'
RPI_LINE='MACHINE = "raspberrypi4-64"'

# Check if the file contains a line starting with MACHINE=
if grep -q "$SEARCH_PATTERN" "$FILE"; then
    # If the first argument is qemu, replace with QEMU_LINE
    if [[ "$1" == "qemu" ]]; then
        sed -i "s|$SEARCH_PATTERN.*|$QEMU_LINE|" "$FILE"
        echo "Replaced with $QEMU_LINE in $FILE"
    else
        # Otherwise, replace with RPI_LINE
        sed -i "s|$SEARCH_PATTERN.*|$RPI_LINE|" "$FILE"
        echo "Replaced with $RPI_LINE in $FILE"
    fi
else
    echo "No line starting with 'MACHINE=' found in $FILE"
    echo "$RPI_LINE" >> "$FILE"
fi

cat conf/local.conf | grep "${LICENSEFLAGLINE}" > /dev/null
local_conf_info=$?

if [ $local_conf_info -ne 0 ];then
	echo "Append ${LICENSEFLAGLINE} in the local.conf file"
	echo ${LICENSEFLAGLINE} >> conf/local.conf

else
	echo "${LICENSEFLAGLINE} already exists in the local.conf file"
fi

bitbake-layers show-layers | grep "meta-raspberrypi" > /dev/null
layer_info=$?

if [ $layer_info -ne 0 ];then
	echo "Adding meta-raspberrypi layer"
	bitbake-layers add-layer ../meta-raspberrypi
else
	echo "meta-raspberrypi layer already exists"
fi

set -e
bitbake aesdproj-image

