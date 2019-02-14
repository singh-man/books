## This is for WSL 10 but can be used in other stand alone linux as well

##### lxrun /uninstall /full ---- lxrun /install

### Freshly install linux first run
```sh
sudo apt-get update && sudo apt-get upgrade
```

### Install **dev tools below**
```sh
sudo apt install git nginx openssh-client openssh-server
sudo apt install python3-pip
pip3 install pytest
# Google for docker-ce, awscli
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
mkdir dev && mkdir dev/opt && mkdir dev/opt/lein
wget -O dev/opt/lein/lein.sh https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod 755 dev/opt/lein/lein.sh

# udpate .bashrc
echo "LEIN_HOME=$HOME/dev/opt/lein/" >> ~/.bashrc
echo "export LEIN_HOME" >> ~/.bashrc
```

### .bashrc --> User specific aliases and functions
```sh
#The alias command can be useful if you want to create a 'shortcut' to a command.
alias lein='$LEIN_HOME/lein.sh'
```

#### Install Maven
```sh
cd ~
mkdir dev && mkdir dev/opt
wget http://ftp.heanet.ie/mirrors/www.apache.org/dist/maven/maven-3/3.6.0/binaries/apache-maven-3.6.0-bin.tar.gz
tar -C ./dev/opt -xvf apache-maven-3.6.0-bin.tar.gz 
rm apache-maven-3.6.0-bin.tar.gz

# udpate .bashrc
# For WSL ~/.m2/settings.xml add <localRepository>/c/Users/msingh/.m2/repository</localRepository> to point to windows home .m2
echo "M2_HOME=/home/manish/dev/opt/apache-maven-3.6.0" >> ~/.bashrc
echo "export M2_HOME" >> ~/.bashrc
echo "export M2=$M2_HOME/bin" >> ~/.bashrc
echo "export PATH=$M2:$PATH" >> ~/.bashrc
```

#### If Using WSL to execute commands on docker installed on windows. Do remember to enable TCP daemon from docker settings.
```sh
echo "export DOCKER_HOST=tcp://localhost:2375" >> ~/.bashrc && source ~/.bashrc
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
