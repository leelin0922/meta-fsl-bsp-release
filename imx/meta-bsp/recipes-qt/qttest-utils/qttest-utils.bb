DESCRIPTION = "Essa aplica&ccedil;&atilde;o faz parte do artigo para o embarcados"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"
 
SRC_URI = "git://github.com/leelin0922/QT-examplexs.git;protocol=git;branch=qt-utils"
SRCREV = "f0747a818c8f395d9229c88b66469333df6ac96c"
S = "${WORKDIR}/git"
 
DEPENDS = "qtdeclarative qtgraphicaleffects"
RDEPENDS_${PN} = "qtdeclarative-qmlplugins qtgraphicaleffects-qmlplugins"
 
require recipes-qt/qt5/qt5.inc
 
do_install() {
     oe_runmake INSTALL_ROOT=${D} install
     install -d ${D}/${datadir}/pixmaps
     install -d ${D}/${datadir}/applications
     install -m 0664 ${WORKDIR}/git/utils.png ${D}/${datadir}/pixmaps
     install -m 0664 ${WORKDIR}/git/utils.desktop ${D}/${datadir}/applications
}
 

