## This is for WSL 10 but can be used in other stand alone linux as well

##### lxrun /uninstall /full ---- lxrun /install

### Freshly install linux first run
```sh
sudo apt-get update && sudo apt-get upgrade
```

### WSL (only) -> change the mount from /mnt/c/ to /c

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

### Install **dev tools below**
```sh
sudo apt install git nginx openssh-client openssh-server nmap
sudo apt install python3-pip
pip3 install pytest
# Google for docker-ce, awscli
```

##### If Using WSL to execute commands on docker installed on windows. Do remember to enable TCP daemon from docker settings. |https://nickjanetakis.com/blog/setting-up-docker-for-windows-and-wsl-to-work-flawlessly
```sh
echo "export DOCKER_HOST=tcp://localhost:2375" >> ~/.bashrc && source ~/.bashrc
```

#### Install Java 10 or 11
```sh
sudo add-apt-repository ppa:linuxuprising/java
sudo apt update
sudo apt install oracle-java10-installer

OR

sudo apt install openjdk-11-jdk-headless

# udpate .bashrc "Find Java home dir first"
echo "JAVA_HOME=/etc/alternatives/<java home dir>/" >> ~./bashrc
echo "export JAVA_HOME" >> ~./bashrc
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

### Install **Misc tools**
```sh
sudo apt install pandoc poppler-utils elinks
```

### Install ffmpeg
```sh
sudo add-apt-repository ppa:jonathonf/ffmpeg-4 && sudo apt-get update && sudo apt-get dist-upgrade
sudo apt install ffmpeg
```

### SDKMAN should be last line in bashrc so run this in end Install SDKMAN and Gradle
```sh
sudo apt install unzip 
sudo apt install zip
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
sdk install gradle 4.8.1
```

### Software to Install
- sudo apt-get install xubuntu-restricted-extras
- install
	- arc dark theme
	- browser
		- chromium
		- elinks
		- firefox
		- tor
	- git
		- git extensions
	- IDE
		- android studio
		- eclipse
		- intellij
		- sublime text
		- Visual studio code
	- programming env
		- git
		- gradle
		- java 10
		- lein (clojure)
		- maxima
		- nodejs
	- blender
	- calibre
	- cheese
	- dropbox
	- gimp
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
