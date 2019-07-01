var drawnItems = new L.FeatureGroup();
map.addLayer(drawnItems);

var drawControl = new L.Control.Draw({
edit: {
featureGroup: drawnItems
}
});
map.on('draw:created', function (e) {
var type = e.layerType,
layer = e.layer;
drawnItems.addLayer(layer);
});

var drawControl = new L.Control.Draw({
edit: {
featureGroup: drawnItems
}
});
map.addControl(drawControl);
      map.on('draw:created', function (e) {
            var type = e.layerType,
                layer = e.layer;
            drawnItems.addLayer(layer);
        });


//var lat = parseFloat( $("#lat").html());
//var lng = parseFloat($("#lng").html());
//var marker = L.marker([lat, lng]).addTo(map);

var storyId=parseInt($("#storyId").val());


fetch("/api/"+ storyId)
.then(r => r.json())
.then(r => {
	r.points.forEach(point => {
		L.marker([point.lat, point.lng]).addTo(map);
    });

    });




