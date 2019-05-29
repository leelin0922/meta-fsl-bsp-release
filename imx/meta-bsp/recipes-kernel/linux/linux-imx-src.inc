# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

#SRCBRANCH = "imx_4.9.88_2.0.0_ga"
SRCBRANCH = "SBC-7819S_Linux_Kernel-v4.9.88"
#LOCALVERSION = "-${SRCBRANCH}"
LOCALVERSION = ""
SCMVERSION = "n"

#KERNEL_SRC ?= "git://source.codeaurora.org/external/imx/linux-imx.git;protocol=https"
KERNEL_SRC ?= "git://github.com/leelin0922/kernel-source.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
#SRCREV = "5e23f9d6114784d77fd4ed5848953356c3575532"
SRCREV = "0dbfd85e6d6b23aee9a2bb42704ddaa8addd515e"

S = "${WORKDIR}/git"
