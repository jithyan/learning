interface Mappable {
  location: {
    lat: number;
    lng: number;
  };
  markerContent?(): string;
}

export class CustomMap {
  private map: google.maps.Map;

  constructor(divId: string) {
    this.map = new google.maps.Map(document.getElementById(divId), {
      zoom: 1,
      center: {
        lat: 0,
        lng: 0
      }
    });
  }

  addMarker({ location: { lat, lng }, markerContent }: Mappable) {
    const marker = new google.maps.Marker({
      map: this.map,
      position: { lat, lng }
    });
    const mContent = markerContent();
    console.log(mContent);
    marker.addListener("click", () => {
      const infoWindow = new google.maps.InfoWindow({
        content: mContent
      });

      infoWindow.open(this.map, marker);
    });
  }
}
