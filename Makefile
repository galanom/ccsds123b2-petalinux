.PHONY: all build package

ifndef PETALINUX
$(error Please source the PetaLinux settings.sh file.)
else
$(info Using PetaLinux version $(PETALINUX_VER) from $(PETALINUX))
endif

all:	package

package: build
	petalinux-package boot --u-boot --fpga --force
	petalinux-package wic --images-dir images/linux/ --bootfiles "ramdisk.cpio.gz.u-boot,boot.scr,Image,system.dtb,system-zynqmp-sck-kv-g-revB.dtb"
	xz -kf -T0 -1 images/linux/petalinux-sdimage.wic

build:
	petalinux-build
