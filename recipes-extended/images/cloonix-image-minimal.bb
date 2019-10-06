SUMMARY = "A small image just capable of allowing a device to boot and run cloonix backdoor."
DESCRIPTION = ""
HOMEPAGE = ""

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

IMAGE_INSTALL = "packagegroup-core-boot ${CORE_IMAGE_EXTRA_INSTALL}"

APPEND += " console=ttyS0,115200 console=tty0 earlyprintk=serial net.ifnames=0"

#IMAGE_LINGUAS = " "

LICENSE = "MIT"

IMAGE_FSTYPES = "wic.qcow2"

inherit core-image
inherit extrausers

# TODO: we really need this ?
EXTRA_USERS_PARAMS = "\
    usermod -P root root; \
    "

IMAGE_ROOTFS_SIZE ?= "8192"
IMAGE_ROOTFS_EXTRA_SPACE_append = "${@bb.utils.contains("DISTRO_FEATURES", "systemd", " + 4096", "" ,d)}"

do_populate_cloonix() {
	mkdir ${IMAGE_ROOTFS}/root
}

IMAGE_PREPROCESS_COMMAND += "do_populate_cloonix; "
