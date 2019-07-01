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

map.on("draw:created", function (e) {
    var type = e.layerType,
        layer = e.layer;

    if (type === 'marker') {
        // Do marker specific actions
        var latlng = e.layer._latlng;
        var lat = $("form input[name='lat']").val(latlng.lat);
        var lng = $("form input[name='lng']").val(latlng.lng);
    }

    map.addLayer(layer);


map.on
L.marker([lat, lng]).addTo(map);

});

