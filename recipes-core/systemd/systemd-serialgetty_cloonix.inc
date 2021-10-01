FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += "file://serial-getty@hvc0.service"

do_install_append() {
    install -d ${D}${systemd_unitdir}/system/
    install -d ${D}${sysconfdir}/systemd/system/getty.target.wants/
    install -m 0644 ${WORKDIR}/serial-getty@hvc0.service ${D}${systemd_unitdir}/system/
    ln -sf ${systemd_unitdir}/system/serial-getty@hvc0.service \
            ${D}${sysconfdir}/systemd/system/getty.target.wants/serial-getty@hvc0.service
}