# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017 NXP

DESCRIPTION = "i.MX U-Boot suppporting i.MX reference boards."
require recipes-bsp/u-boot/u-boot.inc

PROVIDES += "u-boot"
DEPENDS_append = "dtc-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/gpl-2.0.txt;md5=b234ee4d69f5fce4486a80fdaf4a4263"

#SRCBRANCH = "imx_v2017.03_4.9.11_1.0.0_ga"
#UBOOT_SRC ?= "git://git.freescale.com/imx/uboot-imx.git;protocol=git"
#SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
#SRCREV = "a2fea67d3eb3092f19f250d53a4a27fa1a0c815f"
SRCBRANCH = "SBC-7112S_Linux_Uboot-v2017.03"
UBOOT_SRC ?= "git://github.com/AplexOS/U-Boot.git;protocol=git"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH}"
SRCREV = "830fe20044a8ea38c909ac6d977677e860137d63"

S = "${WORKDIR}/git"

inherit fsl-u-boot-localversion

LOCALVERSION ?= "-${SRCBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
COMPATIBLE_MACHINE = "(mx6|mx7)"
