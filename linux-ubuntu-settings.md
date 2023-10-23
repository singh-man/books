## This is for Ubuntu set-up and can also be used for  WSL2

### Freshly install linux first run
```sh
sudo apt update && sudo apt upgrade && sudo apt autoremove
OR
sudo apt-get update && sudo apt-get upgrade && sudo apt autoremove
```

### Install Nala 
A front end to apt, which looks like **dnf** https://github.com/volitank/nala    
```sh
sudo apt install nala
```
Now **apt** anywhere can be replaced with **nala**

### WSL (only) 
#### change the mount from /mnt/c/ to /c

> This step is mandatory if using WSL to execute docker commands installed on windows otherwise skip to next section.

In a WSL terminal
```sh
sudo nano /etc/wsl.conf

# Now make it look like this and save the file when you're done:
[automount]
root = /
options = "metadata"
```
We need to set root = / because this will make your drives mounted at /c or /e instead of /mnt/c or /mnt/e.

The options = "metadata" line is not necessary but it will fix folder and file permissions on WSL mounts so everything isn’t 777 all the time within the WSL mounts. I highly recommend you do this!

Once you make those changes, sign out and sign back in to Windows to ensure the changes take effect. Win + L isn’t enough. You’ll need to do a full blown sign out / sign in.

**If you get an error the next time you start your WSL terminal don’t freak out.**

It’s a bug with 18.03 and you can easily fix it. Hit CTRL + Shift + ECS to open the task manager, goto the “Services” tab, find the “LxssManager” service and restart it.

**WSL2 not connecting to internet in win version 2004 or in genearl**

Follow the steps https://github.com/microsoft/WSL/issues/5256#issuecomment-666545999

#### Alpine on WSL 2 on windows 10
Get the root filesystem for the alpine from https://alpinelinux.org/downloads/
Import the new system via `wsl --import <root filesystem>`
> alpine via this way will have root user and root permissions.

> latest NeoVim if not available in apk, compile it by following the NeoVim by source.

### Install **below packages**
```sh
# Ripgrep for neovim's telescope plugin
sudo apt install -y git nginx openssh-client openssh-server nmap unzip zip pandoc poppler-utils elinks maxima ripgrep python3-pip
pip3 install pytest

# Install terminal file explorer "ranger" and terminal image viewer
pip3 install ranger-fm
sudo apt install w3m sxiv

# Install lazygit, follow
https://github.com/jesseduffield/lazygit#ubuntu

# Install and setup Neovim, follow
https://github.com/singh-man/nvim-IDE

# Google
## docker-ce, docker-compose, awscli
## don't install docker with snap, it causes volume mounting problem
## docker in Linux needs to be run with 'sudo' or else add the user in sudo group. "google" how to do that.

# Install sdkman for java, gradle, maven, lein and others (SDKMAN should be last line in .bashrc)
# SDKMAN on windows use git bash; hence make a copy of 7z.exe as zip.exe; than export 7z root folder path as PATH.
# SDKMAN doesn't set M2_HOME and JAVA_HOME do set it in .profile
https://sdkman.io/install

# snap (always search snap alternative)
## ffmpeg, sublimetext, vscode, dbeaver

# udpate .bashrc
# For WSL ~/.m2/settings.xml add <localRepository>/c/Users/msingh/.m2/repository</localRepository> to point to windows home .m2
echo "M2_HOME=<path>/apache-maven-3.6.0" >> ~/.bashrc
echo "export M2_HOME" >> ~/.bashrc
echo "export M2=$M2_HOME/bin" >> ~/.bashrc
echo "export PATH=$M2:$PATH" >> ~/.bashrc
echo "alias mvn_cist='mvn clean install -Dmaven.test.skip'" >> ~/.bashrc

# NOTE: Recommended to use "myAlias" file in home and do 'source ~/myAlias' in ".bashrc" or ".bash_profile"
```

##### If Using WSL to execute commands on docker installed on windows. Do remember to enable TCP daemon from docker settings. |https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly

In windows 10 if using Git Bash use .bash_profile present in \<user home\>. Do note if using visual studio code add JAVA_HOME to .bash_profile so that maven can work.

### Git and multiple SSH keys

If there are multiple accounts in github or bitbucket all using different keys, follow:

https://gist.github.com/aprilmintacpineda/f101bf5fd34f1e6664497cf4b9b9345f

https://psychowhiz.medium.com/configuring-multiple-ssh-keys-for-git-on-the-same-device-41c29320e5fe

OR Try

GIT_SSH_COMMAND
e.g. export GIT_SSH_COMMAND="ssh -i ~/.ssh/id_rsa_example -F /dev/null" than run any git push or merge command

OR better do
> Make sure git config --list doesn't show remote origin like ~https://~ it should be like git@github.com:singh-man/books.git

```
git config core.sshCommand "ssh -i ~/.ssh/id_rsa_example -F /dev/null"
```


### VirutualBox
- Use bridge adapter so that VM get its own dedicated ip address for easier ssh from anywhere in local network
- give half of CPU and ample RAM
- guest additions installation works from inside the ubuntu apt install

### Software to Install
- sudo apt-get install lubuntu-restricted-extras
- install
	- browser
		- chromium
		- elinks
		- firefox
		- tor
	- IDE
		- android studio
		- ~eclipse~
		- intellij
		- sublime text
		- Visual Studio Code
		- DBeaver db browser
		- neovim with plugins
	- programming env
	 	- git extensions
		- maxima, wxmaxima
		- nodejs -> check Coci.nvim page, how to install.
		- MemoryAnalyzer
		- VisualVM
	- blender
	- calibre
	- cheese
	- dropbox
	- gimp (gmic plugin)
	- gparted
	- handbrake
	- libre office
	- shotcut
	- teams
	- transmission
	- vlc
- ? sudo apt install gnome-tweak-tool

## Intellij modifications
- Change the compiler from Javac to eclipse
- Change compiler settings
	- uncheck "Automatically show first error in editor"
	- Check "Build Project automatically"
- Build Tools
	- Gradle
		- Build and run using: Intellij IDEA
		- Run test using: Choose per test
- Terminal
	- Shell Path: "C:\Program Files\Git\bin\sh.exe" --login -i 
- WSL2
    - Open Module Settings -> Project -> make sure it only has the JDK installed in wsl2. Remove any other JDK.

### Intellij import projects
How to import existing maven, gradle projects in intellij after git clone.
https://www.jetbrains.com/help/idea/maven-support.html#maven_import_project_start

OR try ==> File -> Project From existing sources -> Import project from external model (maven | gradle) -> Finish -> New Window

### Dark Reader (for browsers)
Brightness: -5
Contrast: -35
Sepia: +55
Grayscale: +25
