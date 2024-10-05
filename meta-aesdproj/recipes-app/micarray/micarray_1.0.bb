SUMMARY = "Mic Array"
DESCRIPTION = "An application that creates a microphone array from usb microphones"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=76dd0cf4faac38c6310a417ff5bb36b9"

SRC_URI = "git://git@github.com/velascorhwee/final-project-assignment-micarray.git;protocol=ssh;branch=main"

# Specify the revision or commit to fetch
SRCREV = "${AUTOREV}"

# Directory where the application will be built (in ${WORKDIR})
S = "${WORKDIR}/git"

# Dependencies for your application (e.g., for ALSA, etc.)
DEPENDS += "alsa-lib libusb1 pkgconfig-native"

inherit cmake
# or autotools, if using that build system

do_install() {
    install -d ${D}${bindir}
    install -m 0755 MicArray ${D}${bindir}
}

