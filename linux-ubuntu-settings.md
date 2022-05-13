## This is for WSL 10 but can be used in other stand alone linux as well

##### lxrun /uninstall /full ---- lxrun /install

### Freshly install linux first run
```sh
sudo apt-get update && sudo apt-get upgrade && sudo apt autoremove
```

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

#### Fedora 33 WSL 2 on windows 10
Follow:
https://dev.to/bowmanjd/install-fedora-on-windows-subsystem-for-linux-wsl-4b26

Below install successfully
dnf install nano git nmap python3 python3-pip unzip zip maxima elinks -y && pip3 install pytest
dnf clean all

Trouble: will mess up the /etc/resolv.conf file and then all upgrades and installation will start failing.

dnf install nginx poppler-utils postgres

#### Alpine on WSL 2 on windows 10
Get the root filesystem for the alpine from https://alpinelinux.org/downloads/
Import the new system via wsl --import ......
> alpine via this way will have root user and root permissions.

> latest NeoVim if not available in apk, compile it by following the NeoVim by source.

### Install **below packages**
```sh
sudo apt install -y git nginx openssh-client openssh-server nmap unzip zip pandoc poppler-utils elinks maxima ripgrep lazygit python3-pip
pip3 install pytest 
- ripgrep is used by telescope plugin for neovim
sudo apt install -y nnn trash-cli sxiv
> nnn works only on env variables.
- Google
-- docker-ce, docker-compose, awscli
> don't install docker with snap, it causes volume mounting problem
> docker in Linux needs to be run with 'sudo' or else add the user in sudo group. "google" how to do that.
-- neovim (plugins: telescope, treesitter, nvim_cmp, nvim_lsp .....)
- sdkman (SDKMAN should be last line in bashrc)
-- java, gradle, maven, lein and others
>>> SDKMAN on windows use git bash and make a copy of 7z.exe as zip.exe; than export 7z root folder path as PATH.
-- *SDKMAN doesn't set M2_HOME and JAVA_HOME do set it in .profile*
- snap (always search snap alternative)
-- ffmpeg, sublimetext, vscode, dbeaver

# udpate .bashrc
# For WSL ~/.m2/settings.xml add <localRepository>/c/Users/msingh/.m2/repository</localRepository> to point to windows home .m2
echo "M2_HOME=<path>/apache-maven-3.6.0" >> ~/.bashrc
echo "export M2_HOME" >> ~/.bashrc
echo "export M2=$M2_HOME/bin" >> ~/.bashrc
echo "export PATH=$M2:$PATH" >> ~/.bashrc
echo "alias mvn_cist='mvn clean install -Dmaven.test.skip'" >> ~/.bashrc
```

##### If Using WSL to execute commands on docker installed on windows. Do remember to enable TCP daemon from docker settings. |https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly
```sh
# This step not needed if using WSL 2
echo "export DOCKER_HOST=tcp://localhost:2375" >> ~/.bashrc && source ~/.bashrc
```

In windows 10 if using Git Bash use .bash_profile present in \<user home\>. Do note if using visual studio code add JAVA_HOME to .bash_profile so that maven can work.

### Git and multiple SSH keys

If there are multiple accounts in github or bitbucket all using different keys follow:

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
		- eclipse
		- intellij
		- sublime text
		- Visual studio code
		- DBeaver db browser
		- neovim with plugins
	- programming env
	 	- git extensions
		- maxima, wxmaxima
		- nodejs
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
	- skype
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
		- Tun test using: Choose per test
- Terminal
	- Shell Path: "C:\Program Files\Git\bin\sh.exe" --login -i 

### Intellij import projects
How to import existing maven, gradle projects in intellij after git clone.
https://www.jetbrains.com/help/idea/maven-support.html#maven_import_project_start

OR try ==> File -> Project From existing sources -> Import project from external model (maven | gradle) -> Finish -> New Window
