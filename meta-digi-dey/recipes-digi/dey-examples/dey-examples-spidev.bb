# Copyright (C) 2013-2017, Digi International Inc.

SUMMARY = "DEY examples: SPI device driver test application"
SECTION = "examples"
LICENSE = "GPL-2.0"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRC_URI = "file://spidev_test"

S = "${WORKDIR}/spidev_test"

do_compile() {
	${CC} -O2 -Wall ${LDFLAGS} spidev_test.c -o spidev_test
}

do_install() {
	install -d ${D}${bindir}
	install -m 0755 spidev_test ${D}${bindir}
}

PACKAGE_ARCH = "${MACHINE_ARCH}"
