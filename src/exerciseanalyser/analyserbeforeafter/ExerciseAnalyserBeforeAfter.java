package exerciseanalyser.analyserbeforeafter;

import exerciseanalyser.ExerciseAnalyser;
import java.util.ArrayList;

/**
 *
 * @author Matteo Ciman
 */
public class ExerciseAnalyserBeforeAfter 
{
    private final ArrayList<Float> accelerometerData = new ArrayList<Float>();
    private final ArrayList<String> featuresAccelerometerData = new ArrayList<String>();
    
    private final ArrayList<Float> accelerometerRotatedData = new ArrayList<Float>();
    private final ArrayList<String> featuresAccelerometerRotatedData = new ArrayList<String>();
    
    private final ArrayList<Float> accelerometerNoGravityData = new ArrayList<Float>();
    private final ArrayList<String> featuresAccelerometerNoGravityData = new ArrayList<String>();
    
    private final ArrayList<Float> accelerometerNoGravityRotatedData = new ArrayList<Float>();
    private final ArrayList<String> featuresAccelerometerNoGravityRotatedData = new ArrayList<String>();
    
    private final ArrayList<Float> linearData = new ArrayList<Float>();
    private final ArrayList<String> featuresLinearData = new ArrayList<String>();
    
    private final ArrayList<Float> linearRotatedData = new ArrayList<Float>();
    private final ArrayList<String> featuresLinearRotatedData = new ArrayList<String>();
    
    private final ArrayList<Float> rotationData = new ArrayList<Float>();
    private final ArrayList<String> featuresRotationData = new ArrayList<String>();
    
    private final ArrayList<Float> gravityData = new ArrayList<Float>();
    private final ArrayList<String> featuresGravityData = new ArrayList<String>();
    
    private final ArrayList<Float> gyroscopeData = new ArrayList<Float>();
    private final ArrayList<String> featuresGyroscopeData = new ArrayList<String>();
    
    private final ArrayList<Float> magneticFieldData = new ArrayList<Float>();
    private final ArrayList<String> featuresMagneticFieldData = new ArrayList<String>();
    
    private final ArrayList<Float> ambientTemperatureData = new ArrayList<Float>();
    private final ArrayList<String> featuresAmbientTemperatureData = new ArrayList<String>();
    
    private final ArrayList<Float> lightData = new ArrayList<Float>();
    private final ArrayList<String> featuresLightData = new ArrayList<String>();
    
    private final ArrayList<Float> pressureData = new ArrayList<Float>();
    private final ArrayList<String> featuresPressureData = new ArrayList<String>();
    
    private final ArrayList<Float> relativeHumidityData = new ArrayList<Float>();
    private final ArrayList<String> featuresRelativeHumidity = new ArrayList<String>();
    
    public ExerciseAnalyserBeforeAfter(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        calculateAccelerometerRatios(before, after);
        calculateAccelerometerRotatedRatios(before, after);
        calculateAccelerometerNoGravityRatios(before, after);
        calculateAccelerometerNoGravityRotatedRatios(before, after);
        calculateLinearRatios(before, after);
        calculateLinearRotatedRatios(before, after);
        calculateRotationRatios(before, after);
        calculateGravityRatios(before, after);
        calculateGyroscopeRatios(before, after);
        calculateMagneticFieldRatios(before, after);
        calculateAmbientTemperatureRatios(before, after);
        calculateLightRatios(before, after);
        calculatePressureRatios(before, after);
        calculateRelativeHumidityRatios(before, after);
    }
    
    /**
     * Saves all the features value for the accelerometer, using before, after
     * and the ratio values
     * @param before features from buffer before
     * @param after features from bugger after
     */
    private void calculateAccelerometerRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        ArrayList<Float> featuresBefore = before.getAccelerometerData().getFeatures(),
                featuresAfter = after.getAccelerometerData().getFeatures();
        
        ArrayList<String> featuresName = before.getAccelerometerData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++)
        {
        	featuresAccelerometerData.add("BEFORE_" + featuresName.get(i));
        	featuresAccelerometerData.add("AFTER_" + featuresName.get(i));
            featuresAccelerometerData.add("RATIO_" + featuresName.get(i));
            
            accelerometerData.add(featuresBefore.get(i)); 
            accelerometerData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null)
            {
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN())
	            {
	                ratio = 0.0F;
	            }
	            accelerometerData.add(ratio);
            }
            else
            {
                accelerometerData.add(null);
            }
            
        }
    }
    
    /**
     * Adds all features values from buffer before, after and calculating the 
     * ratio between them
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateAccelerometerRotatedRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        ArrayList<Float> featuresBefore = before.getAccelerometerRotatedData().getFeatures(),
                featuresAfter = after.getAccelerometerRotatedData().getFeatures();
        ArrayList<String> featuresName = before.getAccelerometerRotatedData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++)
        {
        	featuresAccelerometerRotatedData.add("BEFORE_" + featuresName.get(i));
        	featuresAccelerometerRotatedData.add("AFTER_" + featuresName.get(i));
            featuresAccelerometerRotatedData.add("RATIO_" + featuresName.get(i));
            
            accelerometerRotatedData.add(featuresBefore.get(i));
            accelerometerRotatedData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null)
            {
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN())
	            {
	                ratio = 0.0F;
	            }
	            accelerometerRotatedData.add(ratio);
	        }
            else
            {
                accelerometerRotatedData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features for the accelerometer without gravity, 
     * using buffer before, after and the ratio
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateAccelerometerNoGravityRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getAccelerometerNoGravityData().getFeatures(),
                featuresAfter = after.getAccelerometerNoGravityData().getFeatures();
        ArrayList<String> featuresName = before.getAccelerometerNoGravityData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
        	featuresAccelerometerNoGravityData.add("BEFORE_" + featuresName.get(i));
        	featuresAccelerometerNoGravityData.add("AFTER_" + featuresName.get(i));
            featuresAccelerometerNoGravityData.add("RATIO_" + featuresName.get(i));
            
            accelerometerNoGravityData.add(featuresBefore.get(i));
            accelerometerNoGravityData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN()) {
	                ratio = 0.0F;
	            }
	            accelerometerNoGravityData.add(ratio);
            }
            else {
                accelerometerNoGravityData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features for the accelerometer without gravity rotated, 
     * using buffer before, after and the ratio
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateAccelerometerNoGravityRotatedRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getAccelerometerNoGravityRotatedData().getFeatures(),
                featuresAfter = after.getAccelerometerNoGravityRotatedData().getFeatures();
        ArrayList<String> featuresName = before.getAccelerometerNoGravityRotatedData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
        	featuresAccelerometerNoGravityRotatedData.add("BEFORE_" + featuresName.get(i));
        	featuresAccelerometerNoGravityRotatedData.add("AFTER_" + featuresName.get(i));
            featuresAccelerometerNoGravityRotatedData.add("RATIO_" + featuresName.get(i));
            
            accelerometerNoGravityRotatedData.add(featuresBefore.get(i));
            accelerometerNoGravityRotatedData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN()) {
	                ratio = 0.0F;
	            }
	            accelerometerNoGravityRotatedData.add(ratio);
            }
            else {
                accelerometerNoGravityRotatedData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features for the linear sensor, using buffer before, after
     * and the ratio
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateLinearRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getLinearData().getFeatures(),
                featuresAfter = after.getLinearData().getFeatures();
        ArrayList<String> featuresName = before.getLinearData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
        	featuresLinearData.add("BEFORE_" + featuresName.get(i));
        	featuresLinearData.add("AFTER_" + featuresName.get(i));
            featuresLinearData.add("RATIO_" + featuresName.get(i));
            
            linearData.add(featuresBefore.get(i)); 
            linearData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN()) {
                    ratio = 0.0F;
                }
                linearData.add(ratio);
            }
            else {
                linearData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features for the linear rotated, using buffer before, 
     * after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateLinearRotatedRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getLinearRotatedData().getFeatures(),
                featuresAfter = after.getLinearRotatedData().getFeatures();
        ArrayList<String> featuresName = before.getLinearRotatedData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
        	featuresLinearRotatedData.add("BEFORE_" + featuresName.get(i));
        	featuresLinearRotatedData.add("AFTER_" + featuresName.get(i));
            featuresLinearRotatedData.add("RATIO_" + featuresName.get(i));
            
            linearRotatedData.add(featuresBefore.get(i));
            linearRotatedData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN()) {
	                ratio = 0F;
	            }
	            linearRotatedData.add(ratio);
            }
            else {
                linearRotatedData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features from the rotation sensor, using buffer before, 
     * after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateRotationRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getRotationData().getFeatures(),
                featuresAfter = after.getRotationData().getFeatures();
        ArrayList<String> featuresName = before.getRotationData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
            
        	featuresRotationData.add("BEFORE_" + featuresName.get(i));
        	featuresRotationData.add("AFTER_" + featuresName.get(i));
            featuresRotationData.add("RATIO_" + featuresName.get(i));
            
            rotationData.add(featuresBefore.get(i));
            rotationData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN()) {
	                ratio = 0.0F;
	            }
	            rotationData.add(ratio);
            }
            else {
                rotationData.add(null);
            }
            
        }
    }
    
    /**
     * Adds all the features from the gravity sensor, using buffer before, 
     * after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateGravityRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getGravityData().getFeatures(),
                featuresAfter = after.getGravityData().getFeatures();
        ArrayList<String> featuresName = before.getGravityData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
            featuresGravityData.add("BEFORE_" + featuresName.get(i));
            featuresGravityData.add("AFTER_" + featuresName.get(i));
            featuresGravityData.add("RATIO_" + featuresName.get(i));
            
            gravityData.add(featuresBefore.get(i));
            gravityData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
	            Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
	            if (ratio.isInfinite() || ratio.isNaN()) {
	                ratio = 0F;
	            }
	            gravityData.add(ratio);
            }
            else {
                gravityData.add(null);
            }
            
        }
    }
    
    /**
     * Adds all the features from the gyroscope sensor, using buffer before, 
     * after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateGyroscopeRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getGyroscopeData().getFeatures(),
                featuresAfter = after.getGyroscopeData().getFeatures();
        ArrayList<String> featuresName = before.getGyroscopeData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
            featuresGyroscopeData.add("BEFORE_" + featuresName.get(i));
            featuresGyroscopeData.add("AFTER_" + featuresName.get(i));
            featuresGyroscopeData.add("RATIO_" + featuresName.get(i));
            
            gyroscopeData.add(featuresBefore.get(i));
            gyroscopeData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN()) {
                    ratio = 0F;
                }
                gyroscopeData.add(ratio);
            }
            else {
                gyroscopeData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features from the magnetic field sensor, using buffer before, 
     * after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateMagneticFieldRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after) {
    	
        ArrayList<Float> featuresBefore = before.getMagneticFieldData().getFeatures(),
                featuresAfter = after.getMagneticFieldData().getFeatures();
        ArrayList<String> featuresName = before.getMagneticFieldData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
        	
        	featuresMagneticFieldData.add("BEFORE_" + featuresName.get(i));
        	featuresMagneticFieldData.add("AFTER_" + featuresName.get(i));
            featuresMagneticFieldData.add("RATIO_" + featuresName.get(i));
            
            magneticFieldData.add(featuresBefore.get(i));
            magneticFieldData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN()) {
                    ratio = 0.0F;
                }
                magneticFieldData.add(ratio);
            }
            else {
                magneticFieldData.add(null);
            }    
        }
    }
    
    /**
     * Adds all the features from the ambient temperature sensor, using buffer
     * before, after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateAmbientTemperatureRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        ArrayList<Float> featuresBefore = before.getAmbientTemperatureData().getFeatures(),
                featuresAfter = after.getAmbientTemperatureData().getFeatures();
        ArrayList<String> featuresName = before.getAmbientTemperatureData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
            	
        	featuresAmbientTemperatureData.add("BEFORE_" + featuresName.get(i));
        	featuresAmbientTemperatureData.add("AFTER_" + featuresName.get(i));
            featuresAmbientTemperatureData.add("RATIO_" + featuresName.get(i));
            
            ambientTemperatureData.add(featuresBefore.get(i));
            ambientTemperatureData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null)
            {
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN())
                {
                    ratio = 0.0F;
                }
                ambientTemperatureData.add(ratio);
            }
            else
            {
                ambientTemperatureData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features from the light sensor, using buffer before, after
     * and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateLightRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        ArrayList<Float> featuresBefore = before.getLightData().getFeatures(),
                featuresAfter = after.getLightData().getFeatures();
        ArrayList<String> featuresName = before.getLightData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
            
        	featuresLightData.add("BEFORE_" + featuresName.get(i));
        	featuresLightData.add("AFTER_" + featuresName.get(i));
            featuresLightData.add("RATIO_" + featuresName.get(i));
            
            lightData.add(featuresBefore.get(i));
            lightData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN())
                {
                    ratio = 0.0F;
                }
                lightData.add(ratio);
            }
            else
            {
                lightData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features from the pressure sensor, using buffer before, 
     * after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculatePressureRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        ArrayList<Float> featuresBefore = before.getPressureData().getFeatures(),
                featuresAfter = after.getPressureData().getFeatures();
        ArrayList<String> featuresName = before.getPressureData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
            	
        	featuresPressureData.add("BEFORE_" + featuresName.get(i));
        	featuresPressureData.add("AFTER_" + featuresName.get(i));
            featuresPressureData.add("RATIO_" + featuresName.get(i));
            
            pressureData.add(featuresBefore.get(i));
            pressureData.add(featuresAfter.get(i));
            
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN())
                {
                    ratio = 0.0F;
                }
                pressureData.add(ratio);
            }
            else
            {
                pressureData.add(null);
            }
        }
    }
    
    /**
     * Adds all the features from the relative humidity sensor, using buffer 
     * before, after and the ratios
     * @param before features from buffer before
     * @param after features from buffer after
     */
    private void calculateRelativeHumidityRatios(ExerciseAnalyser before, 
            ExerciseAnalyser after)
    {
        ArrayList<Float> featuresBefore = before.getRelativeHumidityData().getFeatures(),
                featuresAfter = after.getRelativeHumidityData().getFeatures();
        ArrayList<String> featuresName = before.getRelativeHumidityData().getFeaturesName();
        
        for (int i = 0; i < featuresBefore.size(); i++) {
           	
        	featuresRelativeHumidity.add("BEFORE_" + featuresName.get(i));
        	featuresRelativeHumidity.add("AFTER_" + featuresName.get(i));
            featuresRelativeHumidity.add("RATIO_" + featuresName.get(i));
            
            relativeHumidityData.add(featuresBefore.get(i));
            relativeHumidityData.add(featuresAfter.get(i));
            if (featuresBefore.get(i) != null && featuresAfter.get(i) != null) {
            	
                Float ratio = featuresBefore.get(i) / featuresAfter.get(i);
                if (ratio.isInfinite() || ratio.isNaN())
                {
                    ratio = 0.0F;
                }
                relativeHumidityData.add(ratio);
            }
            else
            {
                relativeHumidityData.add(null);
            }
        }
    }
    
    public String buildFeaturesListForARFF(boolean accelerometer, 
            boolean accelerometerRotated, boolean accelerometerNoGravity, 
            boolean accelerometerNoGravityRotated, boolean linear, 
            boolean linearRotated, boolean rotation, boolean gravity, 
            boolean gyroscope, boolean magneticField, boolean ambientTemperature, 
            boolean light, boolean pressure, boolean relativeHumidity)
    {
        ArrayList<String> listFeatures = new ArrayList<String>();
        
        if (accelerometer)
        {
            listFeatures.addAll(getAccelerometerFeaturesName());
        }
        if (accelerometerRotated)
        {
            listFeatures.addAll(getAccelerometerRotatedFeaturesName());
        }
        if (accelerometerNoGravity)
        {
            listFeatures.addAll(getAccelerometerNoGravityFeaturesName());
        }
        if (accelerometerNoGravityRotated)
        {
            listFeatures.addAll(getAccelerometerNoGravityRotatedFeaturesName());
        }
        if (linear)
        {
            listFeatures.addAll(getLinearFeaturesName());
        }
        if (linearRotated)
        {
            listFeatures.addAll(getLinearRotatedFeaturesName());
        }
        if (rotation)
        {
            listFeatures.addAll(getRotationFeaturesName());
        }
        if (gravity)
        {
            listFeatures.addAll(getGravityFeaturesName());
        }
        if (gyroscope)
        {
            listFeatures.addAll(getGyroscopeFeaturesName());
        }
        if (magneticField)
        {
            listFeatures.addAll(getMagneticFieldFeaturesName());
        }
        if (ambientTemperature)
        {
            listFeatures.addAll(getAmbientTemperatureFeaturesName());
        }
        if (light)
        {
            listFeatures.addAll(getLightFeaturesName());
        }
        if (pressure)
        {
            listFeatures.addAll(getPressureFeaturesName());
        }
        if (relativeHumidity)
        {
            listFeatures.addAll(getRelativeHumidityFeaturesName());
        }
        
        String output = "";
        for (String feature: listFeatures)
        {
            output += "@ATTRIBUTE " + feature + " NUMERIC" 
                    + System.getProperty("line.separator");
        }
        return output;
    }
    
    /**
     * Returns the name of the features for the accelerometer
     * @return List of features names
     */
    public ArrayList<String> getAccelerometerFeaturesName()
    {
        return this.featuresAccelerometerData;
    }
    
    /**
     * Returns the features for the accelerometer
     * @return feature values
     */
    public ArrayList<Float> getAccelerometerFeaturesValues()
    {
        return this.accelerometerData;
    }
    
    
    /**
     * Returns the name of the features for the accelerometer rotated
     * @return List of features name
     */
    public ArrayList<String> getAccelerometerRotatedFeaturesName()
    {
        return this.featuresAccelerometerRotatedData;
    }
    
    /**
     * Returns the features for the accelerometer rotated
     * @return feature value
     */
    public ArrayList<Float> getAccelerometerRotatedValues()
    {
        return this.accelerometerRotatedData;
    }
    
    /**
     * Returns the name of the features from the accelerometer no gravity
     * @return List of features name
     */
    public ArrayList<String> getAccelerometerNoGravityFeaturesName()
    {
        return this.featuresAccelerometerNoGravityData;
    }
    
    /**
     * Returns the features for the accelerometer no gravity
     * @return features value
     */
    public ArrayList<Float> getAccelerometerNoGravityValues()
    {
        return this.accelerometerNoGravityData;
    }
    
    /**
     * Returns the name of the features for the accelerometer no gravity rotated
     * @return List of features name
     */
    public ArrayList<String> getAccelerometerNoGravityRotatedFeaturesName()
    {
        return this.featuresAccelerometerNoGravityRotatedData;
    }
    
    /**
     * Returns the features for the accelerometer no gravity rotated
     * @return features value
     */
    public ArrayList<Float> getAccelerometerNoGravityRotatedValues()
    {
        return this.accelerometerNoGravityRotatedData;
    }
    
    /**
     * Returns the name of the features for the linear
     * @return features name
     */
    public ArrayList<String> getLinearFeaturesName()
    {
        return this.featuresLinearData;
    }
    
    /**
     * Returns the features for the linear
     * @return features value
     */
    public ArrayList<Float> getLinearValues()
    {
        return this.linearData;
    }
    
    /**
     * Returns the name of the features for the linear rotated
     * @return features name
     */
    public ArrayList<String> getLinearRotatedFeaturesName()
    {
        return this.featuresLinearRotatedData;
    }
    
    /**
     * Returns the features value for the linear rotated
     * @return
     */
    public ArrayList<Float> getLinearRotatedValues()
    {
        return this.linearRotatedData;
    }
    
    /**
     * Returns the name of the features for the rotation sensor
     * @return features name
     */
    public ArrayList<String> getRotationFeaturesName()
    {
        return this.featuresRotationData;
    }
    
    /**
     * Returns the features value for the rotation
     * @return features value
     */
    public ArrayList<Float> getRotationValues()
    {
        return this.rotationData;
    }
    
    /**
     * Returns the name of the features for the gravity sensor
     * @return features name
     */
    public ArrayList<String> getGravityFeaturesName()
    {
        return this.featuresGravityData;
    }
    
    /**
     * Returns the features vale for the gravity sensor
     * @return features value
     */
    public ArrayList<Float> getGravityValues()
    {
        return this.gravityData;
    }
    
    /**
     * Returns the features name for the gyroscope sensor
     * @return features name
     */
    public ArrayList<String> getGyroscopeFeaturesName()
    {
        return this.featuresGyroscopeData;
    }
    
    /**
     * Returns the features value for the gyroscope sensor
     * @return features value
     */
    public ArrayList<Float> getGyroscopeValues()
    {
        return this.gyroscopeData;
    }
    
    /**
     * Returns the features name for the magnetic field sensor
     * @return features name
     */
    public ArrayList<String> getMagneticFieldFeaturesName()
    {
        return this.featuresMagneticFieldData;
    }
    
    /**
     * Returns the features value for the magnetic field sensor
     * @return features value
     */
    public ArrayList<Float> getMagneticFieldValues()
    {
        return this.magneticFieldData;
    }
    
    /**
     * Returns the features name for the ambient temperature sensor
     * @return features name
     */
    public ArrayList<String> getAmbientTemperatureFeaturesName()
    {
        return this.featuresAmbientTemperatureData;
    }
    
    /**
     * Returns the features vale for the ambient temperature sensor
     * @return features value
     */
    public ArrayList<Float> getAmbientTemperatureValues()
    {
        return this.ambientTemperatureData;
    }
    
    /**
     * Returns the features name for the light sensor
     * @return features name
     */
    public ArrayList<String> getLightFeaturesName()
    {
        return this.featuresLightData;
    }
    
    /**
     * Returns the features value for the light sensor
     * @return features value
     */
    public ArrayList<Float> getLightValues()
    {
        return this.lightData;
    }
    
    /**
     * Returns the features name for the pressure sensor
     * @return features name
     */
    public ArrayList<String> getPressureFeaturesName()
    {
        return this.featuresPressureData;
    }
    
    /**
     * Returns the features value for the pressure sensor
     * @return features value
     */
    public ArrayList<Float> getPressureValues()
    {
        return this.pressureData;
    }
    
    /**
     * Returns the features name for the relative humidity sensor
     * @return features name
     */
    public ArrayList<String> getRelativeHumidityFeaturesName()
    {
        return this.featuresRelativeHumidity;
    }
    
    /**
     * Returns the features vale for the relative humidity sensor
     * @return features vale
     */
    public ArrayList<Float> getRelativeHumidityValues()
    {
        return this.relativeHumidityData;
    }
}
