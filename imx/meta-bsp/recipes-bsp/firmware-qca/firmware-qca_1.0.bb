# Copyright 2018 NXP

SUMMARY = "Qualcomm Wi-Fi and Bluetooth firmware"
DESCRIPTION = "Qualcomm Wi-Fi and Bluetooth firmware for modules such as QCA9377-3"
SECTION = "base"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://COPYING;md5=6bd2df2910a2234bf6f419b7d2f531a3;"

inherit fsl-eula-unpack allarch

SRC_URI = " ${INTERNAL_MIRROR}/firmware-qca-1.0.bin;fsl-eula=true; \
"
SRC_URI[md5sum] = "396b1c5d74e0cee3c6c56cfd430db87f"
SRC_URI[sha256sum] = "e5cee0bd23f941680f1d995fdca86e842243d0b2f79087b257db1fc42617ae70"

do_install () {
    # Install firmware.conf for QCA modules
    install -d ${D}${sysconfdir}/bluetooth
    cp ${S}/1PJ_QCA9377-3/etc/bluetooth/firmware.conf ${D}${sysconfdir}/bluetooth

    # Install firmware files
    install -d ${D}${base_libdir}
    cp -r ${S}/1PJ_QCA9377-3/lib/firmware ${D}${base_libdir}
    find ${D}${base_libdir} -name CadenceLicense.txt -exec rm {} \;
    find ${D}${base_libdir} -name Notice.txt -exec rm {} \;
}

PACKAGES += "${PN}-9377-3"

ALLOW_EMPTY_${PN} = "1"

FILES_${PN} = ""
FILES_${PN}-9377-3 = " \
                ${sysconfdir}/bluetooth/firmware.conf \
                ${base_libdir}/firmware/qca \
                ${base_libdir}/firmware/wlan \
                ${base_libdir}/firmware/bdwlan30.bin \
                ${base_libdir}/firmware/otp30.bin \
                ${base_libdir}/firmware/qwlan30.bin \
                ${base_libdir}/firmware/utf30.bin \
                ${base_libdir}/firmware/utfbd30.bin \
"