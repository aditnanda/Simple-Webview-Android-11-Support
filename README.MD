# Support Features
1. File Chooser
```code
<input type="file" accept="image/*" />
<input type="file" accept="audio/*" />
<input type="file" accept="video/*" />
<input type="file" accept="*/*" />
```

2. Camera (Not Using Webcam.js)
```code
<script>
navigator.mediaDevices.getUserMedia({
    video: {
        ffacingMode: "user",
        width: { min: 0, ideal: 320, max: 320 },
        height: { min: 0, ideal: 240, max: 240 },
        frameRate: { ideal: 15, max: 30 },
    },
})
.then(function (mediaStream) {
    var video = document.querySelector('#media-device-video');
    if (video) {
        video.srcObject = mediaStream;
        video.onloadedmetadata = function(e) {
            video.play();
        };
    }
})
</script>
```

3. Geolocation
```code
<script>
navigator.geolocation.watchPosition(function(Position) {
    console.log("watch position success.", Position);
})
</script>
```

4. Full-screen video playback
```code
<video width="100%" height="100%" controls>
    <source src="https://www.w3schools.com/html/movie.mp4" type="video/mp4">
    <source src="https://www.w3schools.com/html/movie.ogg" type="video/ogg">
    Your browser does not support the video tag.
</video>
```

5. Native Interface
```code
<script>

const NativeBridge = {

    callToNative: function (plugin, method, args, successCallback, errorCallback) {
        var cbId = _pushCallback(successCallback, errorCallback);

        let jsonObject = {
            "plugin": plugin,
            "method": method,
            "args": args,
            "cbId": cbId
        };

        let query = btoa(encodeURIComponent(JSON.stringify(jsonObject)));

        if (window.AndroidBridge) {
            AndroidBridge.callNativeMethod("native://callToNative?" + query);
        } else if (/iPhone|iPod|iPad/i.test(navigator.userAgent)) {
            if (window.webkit && window.webkit.callbackHandler) {
                window.webkit.messageHandlers.callbackHandler.postMessage("callToNative?" + query);
            } else {
                window.location.href = "native://callToNative?" + query;
            }
        } else {
            console.warn("Native calls are not supported.");
        }
    }
};

