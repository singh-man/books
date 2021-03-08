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
dnf install nginx poppler-utils
postgres

### Install **below packages**
```sh
sudo apt install git nginx openssh-client openssh-server nmap unzip zip
sudo apt install python3-pip
pip3 install pytest
sudo apt install pandoc poppler-utils elinks maxima
# Google for docker-ce, awscli
```

##### If Using WSL to execute commands on docker installed on windows. Do remember to enable TCP daemon from docker settings. |https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly
```sh
# This step not needed if using WSL 2
echo "export DOCKER_HOST=tcp://localhost:2375" >> ~/.bashrc && source ~/.bashrc
```

#### Install leiningen
```sh
cd ~
mkdir -p dev/opt/lein
curl -o dev/opt/lein/lein.sh https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod 755 dev/opt/lein/lein.sh

# udpate .bashrc
echo "LEIN_HOME=$HOME/dev/opt/lein/" >> ~/.bashrc
echo "export LEIN_HOME" >> ~/.bashrc
```

#### .bashrc --> User specific aliases and functions
```sh
#The alias command can be useful if you want to create a 'shortcut' to a command.
alias lein='$LEIN_HOME/lein.sh'
```
In windows 10 if using Git Bash use .bash_profile present in <user home>. Do note if using visual studio code add JAVA_HOME to .bash_profile so that maven can work.

#### Install Maven
```sh
cd ~
mkdir -p dev/opt
wget http://ftp.heanet.ie/mirrors/www.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
tar -C ./dev/opt -xvf apache-maven-3.6.0-bin.tar.gz 
rm apache-maven-3.6.0-bin.tar.gz

# udpate .bashrc
# For WSL ~/.m2/settings.xml add <localRepository>/c/Users/msingh/.m2/repository</localRepository> to point to windows home .m2
echo "M2_HOME=/home/manish/dev/opt/apache-maven-3.6.0" >> ~/.bashrc
echo "export M2_HOME" >> ~/.bashrc
echo "export M2=$M2_HOME/bin" >> ~/.bashrc
echo "export PATH=$M2:$PATH" >> ~/.bashrc
echo "alias mvn_ci='mvn clean install'" >> ~/.bashrc
echo "alias mvn_cist='mvn clean install -Dmaven.test.skip'" >> ~/.bashrc
echo "alias mvn_i='mvn install'" >> ~/.bashrc
echo "alias mvn_ist='mvn install -Dmaven.test.skip'" >> ~/.bashrc
```

### Install ffmpeg
```sh
sudo add-apt-repository ppa:jonathonf/ffmpeg-4 && sudo apt-get update && sudo apt-get dist-upgrade
sudo apt install ffmpeg
or
check snap for ffmpeg, sublimetext, vscode
```

### SDKMAN should be last line in bashrc so run this in end Install SDKMAN and Gradle
```sh
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
sdk install gradle 4.8.1
```

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
	- programming env
		- git
		 	- git extensions
		- gradle
		- jdk
		- lein (clojure)
		- maxima, wxmaxima
		- nodejs
		- python3, pip3
		- MemoryAnalyzer
		- VisualVM
	- blender
	- calibre
	- cheese
	- dropbox
	- gimp (gmic plugin)
	- handbrake
	- libre office
	- pandoc
	- poppler-utils
	- sigil
	- skype
	- transmission
	- vlc
	- gparted
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
