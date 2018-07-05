DESCRIPTION = "Essa aplica&ccedil;&atilde;o faz parte do artigo para o embarcados"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r0"
 
SRC_URI = "git://github.com/AplexOS/Qt-Examples.git;protocol=git;branch=morty"
SRCREV = "ce11902a01d03931545e6e7371ecec4f015ae411"
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
 

