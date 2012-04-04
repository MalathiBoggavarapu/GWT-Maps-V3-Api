package com.google.gwt.maps.client.drawinglib;

import com.google.gwt.ajaxloader.client.ArrayHelper;
import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArrayString;
import com.google.gwt.maps.client.controls.ControlPosition;

/**
 * Options for the rendering of the drawing control.
 * <br><br>
 * See <a href="https://developers.google.com/maps/documentation/javascript/reference#DrawingControlOptions">DrawingControlOptions API Doc</a>
 */
public class DrawingControlOptions extends JavaScriptObject {
  
  /**
   * use newInstance();
   */
  protected DrawingControlOptions() {}
  
  /**
   * Options for the rendering of the drawing control.
   */
  public static final DrawingControlOptions newInstance() {
    return JavaScriptObject.createObject().cast();
  }
  
  /**
   * The drawing modes to display in the drawing control, in the order in which they are to be displayed. The hand icon (which corresponds to the null drawing mode) is always available and is not to be specified in this array. Defaults to [MARKER, POLYLINE, RECTANGLE, CIRCLE, POLYGON].
   * hmmmm, this seems a bit overlay iterative 
   * @param overlayTypes
   */
  public final void setDrawingModes(OverlayType... overlayTypes) {
    if (overlayTypes == null) {
      return;
    }
    String[] types = new String[overlayTypes.length];
    for (int i=0; i < overlayTypes.length; i++) {
      types[i] = overlayTypes[i].value(); 
    }
    JsArrayString drawingModes = ArrayHelper.toJsArrayString(types);
    setDrawingModesImpl(drawingModes);
  }
  
  private final native void setDrawingModesImpl(JsArrayString drawingModes) /*-{
    this.drawingModes = drawingModes;
  }-*/;

  /**
   * The drawing modes to display in the drawing control, in the order in which they are to be displayed. The hand icon (which corresponds to the null drawing mode) is always available and is not to be specified in this array. Defaults to [MARKER, POLYLINE, RECTANGLE, CIRCLE, POLYGON].
   */
  public final OverlayType[] getDrawingModes() {
    JsArrayString types = getDrawingModesImpl();
    if (types == null) {
      return null;
    }
    OverlayType[] r = new OverlayType[types.length()];
    for (int i=0; i < types.length(); i++) {
      r[i] = OverlayType.fromValue(types.get(i));
    }
    return r;
  }

  private final native JsArrayString getDrawingModesImpl() /*-{
    return this.drawingModes;
  }-*/; 
  
  /**
   * Position id. Used to specify the position of the control on the map. The default position is TOP_LEFT.
   * @param position
   */
  public final void setPosition(ControlPosition position) {
    setPositionImpl(position.value());
  }
  
  private final native void setPositionImpl(int position) /*-{
    this.position = position;
  }-*/;
  
  /**
   * Position id. Used to specify the position of the control on the map. The default position is TOP_LEFT.
   */
  public final ControlPosition getPosition() {
    return ControlPosition.fromValue(getPositionImpl());
  }

  private final native int getPositionImpl() /*-{
    return this.position;
  }-*/;
}
