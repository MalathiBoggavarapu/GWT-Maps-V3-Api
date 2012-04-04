package com.google.gwt.maps.client.layers;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.maps.client.MapImpl;
import com.google.gwt.maps.client.MapWidget;
import com.google.gwt.maps.client.mvc.MVCObject;

/**
 * A traffic layer. This class extends MVCObject.
 * <br><br>
 * See <a href="https://developers.google.com/maps/documentation/javascript/reference#TrafficLayer">TrafficLayer API Doc</a>
 */
public class TrafficLayer extends MVCObject<TrafficLayer> {
  
  /**
   * use newInstance();
   */
  protected TrafficLayer() {}
  
  /**
   * creates a traffic layer
   */
  public static final TrafficLayer newInstance() {
    return createJso().cast();
  }

  private static final native  JavaScriptObject createJso() /*-{
    return new $wnd.google.maps.TrafficLayer();
  }-*/;
  
  /**
   * Renders the KML Layer on the specified map. If map is set to null, the layer is removed.
   * @param mapWidget
   */
  public final void setMap(MapWidget mapWidget) {
    setMapImpl(mapWidget.getJso());
  }

  private final native void setMapImpl(MapImpl map) /*-{
    this.setMap(map);
  }-*/;
  
  /**
   * Get the map on which the KML Layer is being rendered.
   */
  public final MapWidget getMap() {
    return MapWidget.newInstance(getMapImpl());
  }

  private final native MapImpl getMapImpl() /*-{
    return this.getMap();
  }-*/;

}
