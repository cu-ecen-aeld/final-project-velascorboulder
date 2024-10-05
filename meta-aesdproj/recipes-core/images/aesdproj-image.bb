SUMMARY = "Final project."

LICENSE = "MIT"

inherit core-image

#COMPATIBLE_MACHINE ="^rpi$"
#IMAGE_INSTALL:append = " packagegroup-rpi-test"
IMAGE_FEATURES += "splash ssh-server-openssh"

#IMAGE_INSTALL += "openssh"
IMAGE_INSTALL += "python3"
IMAGE_INSTALL += "alsa-lib alsa-utils alsa-lib-dev"
IMAGE_INSTALL += "v4l-utils libv4l"
IMAGE_INSTALL += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly gstreamer1.0-libav"
#IMAGE_INSTALL += "xserver-xorg xinit"
IMAGE_INSTALL += "libusb1 libusb1-dev"
IMAGE_INSTALL += "micarray"
#IMAGE_INSTALL += "libcamera"
#IMAGE_INSTALL += "libcamera-gst"
#IMAGE_INSTALL += "libcamera-apps"
#IMAGE_INSTALL += "userland"
#IMAGE_INSTALL += "rpi-config"

#SYSTEMD_AUTO_ENABLE = "enable"

IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "1048000"

