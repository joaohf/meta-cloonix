do_install_append() {
                echo "" >> ${D}${sysconfdir}/inittab
                echo "hvc0:12345:respawn:/sbin/getty -n -l /bin/sh 115200 hvc0" >> ${D}${sysconfdir}/inittab
}
