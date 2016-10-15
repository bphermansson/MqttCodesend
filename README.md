# MqttCodesend
This app sends messages by Mqtt when a button is pressed. There are ten buttons in five groups of two.
Each group can have it's own Mqtt topic, and each button can have it's own payload (Mqtt message).
The topics and the payloads can be set in the app preferences.
For now the button labels are hardcoded, 'on' and 'off', but will be editable in a coming version.

One usage for the app is with a local Mqtt broker running on a Raspberry Pi with Nodered software installed.
In Nodered you can set different actions depending in incoming Mqtt messages, the app can for example
run a command when a message with a certain topic arrives and use the payload as argument for the command.

This can be used with the Codesend utility from 433Utils and a rf-transmitter.
NodeRed is configured with a Mqtt-input that listens to the topic codesend. When a message with
this topic arrives it takes the payload (the actual message) and runs the codesend command with 
the payload as argument. Codesend is a part of 433Utils (https://github.com/ninjablocks/433Utils) 
and uses a 433MHz transmitter to send codes that switch on remote controlled switches.

Codesend uses different codes for different receivers. Thus, the command "codesend 1052693" switches 
on a device and "codesend 1052692" switches it of. 
So if we send a Mqtt-message with the topic "codesend" and the payload "1052693" to the NodeRed server
the switch will turn on. 
