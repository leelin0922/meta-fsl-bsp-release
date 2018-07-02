# Copyright (C) 2013-2016 Freescale Semiconductor
# Copyright 2017 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

SUMMARY = "Linux Kernel provided and supported by NXP"
DESCRIPTION = "Linux Kernel provided and supported by NXP with focus on \
i.MX Family Reference Boards. It includes support for many IPs such as GPU, VPU and IPU."

require recipes-kernel/linux/linux-imx.inc
require recipes-kernel/linux/linux-dtb.inc

DEPENDS += "lzop-native bc-native"

LOCALVERSION = "-1.0.0"
#SRCBRANCH = "imx_4.9.11_1.0.0_ga"
#KERNEL_SRC ?= "git://git.freescale.com/imx/linux-imx.git;protocol=git"
#SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
#SRCREV = "c27010d99a3d91703ea2d1a3f9630a9dedc3f86f"
SRCBRANCH = "SBC-7112S_Linux_Kernel-v4.9.11"
KERNEL_SRC ?= "git://github.com/AplexOS/Linux-Kernel.git;protocol=git"
#KERNEL_SRC ?= "git://github.com/leelin0922/kernel-source.git;protocol=git"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "59093f17de9f48f82ec29f33cb1589aeb2efc419"

DEFAULT_PREFERENCE = "1"

DO_CONFIG_V7_COPY = "no"
DO_CONFIG_V7_COPY_mx6 = "yes"
DO_CONFIG_V7_COPY_mx7 = "yes"

addtask copy_defconfig after do_unpack before do_preconfigure
do_copy_defconfig () {
    install -d ${B}
    if [ ${DO_CONFIG_V7_COPY} = "yes" ]; then
        # copy latest imx_v7_defconfig to use for mx6, mx6ul and mx7
        mkdir -p ${B}
        cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/.config
        cp ${S}/arch/arm/configs/imx_v7_defconfig ${B}/../defconfig
    fi
}

COMPATIBLE_MACHINE = "(mx6|mx7)"
EXTRA_OEMAKE_append_mx6 = " ARCH=arm"
EXTRA_OEMAKE_append_mx7 = " ARCH=arm"
