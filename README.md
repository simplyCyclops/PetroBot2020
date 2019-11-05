# FLL-leJOS
Master/menu infrastructure for running FIRST LEGO League mission programs written in leJOS on the EV3

### Version 2.0
Author: John Meshulam

FLL-leJOS was created with FLL teamns in mind and aims to provide an intuitive and simple way to program FLL robots using Java.

## Should I use this?
### Positives
- Simple to use and teach while installed
- Intuitive and accessible even for teams with little/no coding experience
- Provides a menu for selecting runs, similar to Mindstorms
- Provides support for interrupting robot actions and restarting failed runs instantly

### Negatives
- Complicated setup that requires moderate experience with Java and file handling
- Menu is still extremely basic and some tools are still missing (This will be fixed at a later date)
- Although FLL-leJOS is significantly simpler to use than vanilla leJOS, basic (and some intermediate) Java is still required for teams to use properly. This takes time and effort to teach, and may not fit all audiences. 

## Prequisites
- EV3 Brick
- Micro SD or Micro SDHC card (NOT SDXC!) with at least 4-32GB. (Cards with over 32GB will not work!)
- A Computer running windows 7 or later, with an SD card reader
    - OPTIONAL: Bluetooth or wifi capability
- Patience. The setup and install process is long and complicated. Don't be afraid if it fails the first time.

# Setup

#### leJOS on the EV3
1. Download JDK-8 (latest update, windows x64) from the [official Oracle website](https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
2. Download the latest leJOS EV3 from the [lejos sourceforge page](https://sourceforge.net/projects/ev3.lejos.p/files/). When the installer completes, do not run the EV3SD utility.
3. Format the SD card (You can use the official SD association software available [on their website](https://www.sdcard.org/downloads/formatter/))
4. After you have finished formatting, it's time to create the embedded JRE. These instructions are adapted from [this lejos forum post](https://lejos.sourceforge.io/forum/viewtopic.php?t=6435#p29568)
    - Step 1: Download and install 7-Zip (win64) from [the official website](https://www.7-zip.org/)
    - Step 2: Go to [this ejdk download page](https://www.oracle.com/java/technologies/javaseemeddedev3-downloads.html) and download Java SE embedded version 8
            - (This will download `ejdk-8-fcs-b132-linux-arm-sflt-03_mar_2014.tar.gz`, which I will refer to as the embedded JDK file)
    - Step 3: Create a directory somewhere on your disk. For the rest of this tutorial I will be using `C:\myLejosInstall`
    - Step 4: Unzip the embedded JDK file in `C:\myLejosInstall`. For simplicity purposes, rename the extracted directory to `ejdk8`
    - Step 5: Start a new CMD window inside `C:\myLejosInstall`. This can be done by pressing `SHIFT + Right Click` and selecting `new command prompt window here`. If you are using windows 10, open a powershell window instead and type `cmd` to switch to command prompt.
    - Step 6: Enter the following commands:
        ```sh
        $ cd ejdk8\ejdk1.8.0\bin
        $ jrecreate.bat --dest newjre --profile compact2 --vm client
        ```
        This will create the new EJRE files in a directory named  `newjre` located under `ejdk8\ejdk1.8.0\bin`. Wait for the process to complete, and then close the cmd window.
    - Step 7: Open `C:\myLejosInstall\ejdk8\ejdk1.8.0\bin`, and move the `newjre` directory to `C:\myLejosInstall`
    - Step 8: Rename the `newjre` directory to `ejre-8-b132-linux-arm-sflt` (IMPORTANT!)
    - Step 9: Right click on the directory, select 7Zip -> Add to archive. Select the tar format and accept. This should create `ejre-8-b132-linux-arm-sflt.tar`
    - Step 10: Right click on the directory again, select 7Zip -> Add to archive. Select the gzip format and accept. This should create `ejre-8-b132-linux-arm-sflt.tar.gz`
5. Open your newly formatted SD card with file explorer, and copy the `ejre-8-b132-linux-arm-sflt.tar.gz` from the previous step to it.
6. Go to your leJOS install location (default: `C:\Program Files\leJOS EV3`)
7. Extract the `lejosimage.zip` file using 7Zip to your SD card.
8. Remove the SD card from your computer, insert it into your EV3 brick, and power on. If you have completed all the steps properly, it will start install leJOS, which takes around 10 minutes. If it doesnt work, go ahead and redo step 4, which is where most problems occur.

#### leJOS on your PC
(If you did not install leJOS for the EV3 brick first, complete steps 1 and 2 from the EV3 setup before starting)
1. Download eclipse from the [official website](https://www.eclipse.org/downloads/). Run the installer and select `Eclipse IDE for JAva Developers`
2. Open eclipse, select Help -> Install new software
3. Follow the [instructions on the leJOS wiki](https://sourceforge.net/p/lejos/wiki/Installing%20the%20Eclipse%20plugin/) to install the leJOS eclipse 

# This file is still a work in progress, and will be completed soon!
