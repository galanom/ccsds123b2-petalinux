SUMMARY = "Firmware for the CCSDS123.0-B-2 SoC design"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=570a9b3749dd0463a1778803b12a6dce"

BRANCH = "kv260"
SRC_URI = "git://github.com/galanom/ccsds123b2-fw.git;protocol=https;branch=${BRANCH}"
SRCREV = "${AUTOREV}"

DEPENDS += "dtc-native bootgen-native"

S = "${WORKDIR}/git"
B = "${S}"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${nonarch_base_libdir}/firmware/xilinx/ccsds123b2
    install -m 0644 ${S}/*.bin ${D}${nonarch_base_libdir}/firmware/xilinx/ccsds123b2/
    install -m 0644 ${S}/*.dtbo ${D}${nonarch_base_libdir}/firmware/xilinx/ccsds123b2/
    install -m 0644 ${S}/*.json ${D}${nonarch_base_libdir}/firmware/xilinx/ccsds123b2/
}

FILES:${PN} = "${nonarch_base_libdir}/firmware/xilinx/ccsds123b2"

COMPATIBLE_MACHINE = "^$"
COMPATIBLE_MACHINE:kria = "${MACHINE}"
