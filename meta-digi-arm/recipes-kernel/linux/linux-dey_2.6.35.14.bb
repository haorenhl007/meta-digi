# Copyright (C) 2012 Digi International

require recipes-kernel/linux/linux-dey.inc

COMPATIBLE_MACHINE = "(mxs|mx5)"

# Internal repo branch
SRCBRANCH = "v2.6.35/dey-1.4/maint"

SRCREV_external = "04e6c93c509e4f0b2fe6c713674704f3b3fa1416"
SRCREV_internal = "d320d2a3ad8ba3e45039030b7b59d730d84e0807"
SRCREV = "${@base_conditional('DIGI_INTERNAL_GIT', '1' , '${SRCREV_internal}', '${SRCREV_external}', d)}"

KERNEL_CFG_FRAGS ?= ""
KERNEL_CFG_FRAGS_append_mx5 = "file://config-sahara-module.cfg file://config-camera-module.cfg"
KERNEL_CFG_FRAGS_append_mx5 = " ${@base_contains('MACHINE_FEATURES', 'accelerometer', 'file://config-accel-module.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_mx5 = " ${@base_contains('MACHINE_FEATURES', 'ext-eth', 'file://config-ext-eth-module.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_mx5 = " ${@base_contains('MACHINE_FEATURES', 'wifi', 'file://config-wireless-redpine.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_ccimx51js = " file://config-battery-module.cfg"
KERNEL_CFG_FRAGS_append_mxs = " ${@base_contains('MACHINE_FEATURES', 'wifi', 'file://config-wireless-atheros.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_mxs = " ${@base_contains('MACHINE_FEATURES', 'bluetooth', 'file://config-bluetooth-atheros.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_ccardimx28js = " ${@base_contains('MACHINE_FEATURES', '1-wire', 'file://config-1-wire.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_ccardimx28js = " ${@base_contains('MACHINE_FEATURES', 'ext-eth', 'file://config-ext-eth.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_ccardimx28js = " ${@base_contains('DISTRO_FEATURES', 'x11', 'file://config-fb.cfg file://config-touch.cfg', '', d)}"
KERNEL_CFG_FRAGS_append_ccardimx28js = " ${@base_contains('MACHINE_FEATURES', 'alsa', 'file://config-sound.cfg', '', d)}"
