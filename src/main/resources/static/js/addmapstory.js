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

//

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
