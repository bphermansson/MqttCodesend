# MqttCodesend
An Android app that controls remote controlled switches via Mqtt and Codesend.

This app depends on a local server. This server runs NodeRed, for example the installation 
from Emonpi (http://guide.openenergymonitor.org/) on a Raspberry Pi. 

NodeRed is configured with a Mqtt-input that listens to the topic codesend. When a message with 
this topic arrives it takes the payload (the actual message) and runs the codesend command with 
the payload as argument. Codesend is a part of 433Utils (https://github.com/ninjablocks/433Utils) 
and uses a 433MHz transmitter to send codes that switch on remote controlled switches.

Codesend uses different codes for different receivers. Thus, the command "codesend 1052693" switches 
on a device and "codesend 1052692" switches it of. 
So if we send a Mqtt-message with the topic "codesend" and the payload "1052693" to the NodeRed server
the switch will turn on. 

This app does just that. If you click a button in the gui a Mqtt-message will be sent and the switch turns on (or off). 
