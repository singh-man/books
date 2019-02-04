## This is for WSL 10 but can be used in other stand alone linux as well

##### lxrun /uninstall /full ---- lxrun /install

### Install SDKMAN and Gradle
```sh
sudo apt install unzip 
sudo apt install zip
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
sdk version
sdk install gradle 4.8.1
```

### Install Java 10 or 11
```sh
sudo add-apt-repository ppa:linuxuprising/java
sudo apt update
sudo apt install oracle-java10-installer

OR

sudo apt install openjdk-11-jdk-headless
```

### Install **pandoc, poppler-utils, elinks, git**
```sh
sudo apt install pandoc poppler-utils git
```

### Install ffmpeg
```sh
sudo add-apt-repository ppa:mc3man/trusty-media && sudo apt-get update && sudo apt-get dist-upgrade
sudo apt install ffmpeg
```

# Install leiningen
```sh
cd ~
mkdir dev && mkdir dev/opt && mkdir dev/opt/lein
wget -O dev/opt/lein/lein.sh https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein
chmod 755 dev/opt/lein/lein.sh
```

# .bashrc --> User specific aliases and functions
```sh
JAVA_HOME=/etc/alternatives/<java home dir>/
export JAVA_HOME

LEIN_HOME=$HOME/dev/opt/lein/
export LEIN_HOME

#The alias command can be useful if you want to create a 'shortcut' to a command.
alias lein='$LEIN_HOME/lein.sh'
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
