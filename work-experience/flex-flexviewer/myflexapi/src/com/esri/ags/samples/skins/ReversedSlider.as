package com.esri.ags.samples.skins
{

import mx.controls.VSlider;

public class ReversedSlider extends VSlider
{
    public function ReversedSlider()
    {
        dataTipFormatFunction = formatDataTip;
    }

    private function formatDataTip(value:Number):String
    {
        return String(maximum - value + 1);
    }

    public override function get value():Number
    {
        return maximum - super.value;
    }

    public override function set value(val:Number):void
    {
        super.value = maximum - val;
    }

}
}
