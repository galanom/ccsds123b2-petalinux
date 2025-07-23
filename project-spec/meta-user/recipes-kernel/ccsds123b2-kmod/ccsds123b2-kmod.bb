SUMMARY = "Recipe for  build an external ccsds123b2 Linux kernel module"
SECTION = "PETALINUX/modules"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=570a9b3749dd0463a1778803b12a6dce"
inherit module

INHIBIT_PACKAGE_STRIP = "1"

SRC_URI = "git://github.com/galanom/ccsds123b2-kmod.git;protocol=https;branch=main"
SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

# The inherit of module.bbclass will automatically name module packages with
# "kernel-module-" prefix as required by the oe-core build environment.
