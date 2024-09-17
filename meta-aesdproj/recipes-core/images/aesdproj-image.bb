SUMMARY = "Richard Velasco final AELD final project."

IMAGE_FEATURES += "splash"

LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL += "alsa-lib alsa-utils"
IMAGE_INSTALL += "v4l-utils libv4l"
IMAGE_INSTALL += "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-good gstreamer1.0-plugins-bad gstreamer1.0-plugins-ugly"
IMAGE_INSTALL += "micarray"
CORE_IMAGE_EXTRA_INSTALL += "openssh"
IMAGE_OVERHEAD_FACTOR ?= "1.0"
IMAGE_ROOTFS_SIZE ?= "2048000"
