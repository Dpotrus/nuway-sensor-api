# Nuway Sensor API

With this api you can save sensory observations for devices in a room and the state of the actual room.
You can also return a snapshot of a room's state, and the devices that are in it.

To build project and run tests run ```mvn clean install -U```.


## Example flow

### Add a device 

To add a device, make a POST request to the url "/device".

Example payload:

```
 {
     "id" : 1,
     "name": "Thermostat"
 }
```

### Add a device state

To add a device state, make a POST request to the url "/device-state"

Example payload:
```
{
	"deviceId" : 1,
	"value": 38.2
}
```

### Add a room, and a device to a room

To add a room, make a POST request to "/room"

Example payload:
```
{
	"id" : 1,
	"name": "ThermoRoom",
	"domain": "Stockholm",
	"deviceList": []
}
```

To add a device to a specific room, make a POST request to "/room/{roomId}/device/{deviceId}",
where {roomId} is the id of the room in which you want to put the device and {deviceId} is the id of the device to put into the room.

For example, add the above device with id 1 to the room with id 1 by making a POST to:
"/room/1/device/1".

### Fetch a snapshot of the state of the room

To fetch a snapshot of a room, make a GET request to "/room/{id}", where {id} is the id of the room which you want the snapshot of.
By following the above flow, you should get this as an example of a response:

```
{
    "roomId": 1,
    "roomName": "ThermoRoom",
    "roomDomain": "Stockholm",
    "deviceStates": [
        {
            "deviceId": 1,
            "deviceName": "Thermostat",
            "value": "38.2"
        }
    ]
}
```