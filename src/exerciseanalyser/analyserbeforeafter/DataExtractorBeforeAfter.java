package exerciseanalyser.analyserbeforeafter;

import exerciseanalyser.ExerciseAnalyser;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Matteo Ciman
 */
public class DataExtractorBeforeAfter
{
    private final String target;
    private String targetForOutput;
    private final String activity;
    private final ArrayList<ExerciseAnalyserBeforeAfter> 
            listExerciseAnalyserBeforeAfter = new ArrayList<ExerciseAnalyserBeforeAfter>();
    
    public DataExtractorBeforeAfter(String target, String activity, 
            ArrayList<ExerciseAnalyser> before, 
            ArrayList<ExerciseAnalyser> after)
    {
        this.target = target; this.activity = activity; 
        this.targetForOutput = target;
        for (int i = 0; i < before.size(); i++)
        {
            listExerciseAnalyserBeforeAfter.add(new ExerciseAnalyserBeforeAfter(before.get(i), after.get(i)));
        }
    }
    
    public void changeDestinationForOutput(HashMap<String, String> map)
    {
        if (map.containsKey(target))
        {
            this.targetForOutput = map.get(target);
        }
    }
    
    public String buildFeaturesListForARFF(boolean accelerometer, 
            boolean accelerometerRotated, boolean accelerometerNoGravity, 
            boolean accelerometerNoGravityRotated, boolean linear, 
            boolean linearRotated, boolean rotation, boolean gravity, 
            boolean gyroscope, boolean magneticField, boolean ambientTemperature, 
            boolean light, boolean pressure, boolean relativeHumidity)
    {
        return listExerciseAnalyserBeforeAfter.get(0)
                .buildFeaturesListForARFF(accelerometer, accelerometerRotated, 
                        accelerometerNoGravity, accelerometerNoGravityRotated, 
                        linear, linearRotated, rotation, gravity, gyroscope, 
                        magneticField, ambientTemperature, light, pressure, 
                        relativeHumidity);
    }
    
    public String dataForAllExercises(boolean accelerometer, boolean accelerometerRotated,
            boolean accelerometerNoGravity, boolean accelerometerNoGravityRotated, 
            boolean linear, boolean linearRotated, boolean rotation, boolean gravity, 
            boolean gyroscope, boolean magneticField, boolean ambientTemperature, 
            boolean light, boolean pressure, boolean relativeHumidity)
    {
        
        String finalString = "";
        for (ExerciseAnalyserBeforeAfter exercise: listExerciseAnalyserBeforeAfter)
        {
            ArrayList<Float> features = new ArrayList<Float>();
            if (accelerometer)
            {
                features.addAll(exercise.getAccelerometerFeaturesValues());
            }
            if (accelerometerRotated)
            {
                features.addAll(exercise.getAccelerometerRotatedValues());
            }
            if (accelerometerNoGravity)
            {
                features.addAll(exercise.getAccelerometerNoGravityValues());
            }
            if (accelerometerNoGravityRotated)
            {
                features.addAll(exercise.getAccelerometerNoGravityRotatedValues());
            }
            if (linear)
            {
                features.addAll(exercise.getLinearValues());
            }
            if (linearRotated)
            {
                features.addAll(exercise.getLinearRotatedValues());
            }
            if (rotation)
            {
                features.addAll(exercise.getRotationValues());
            }
            if (gravity)
            {
                features.addAll(exercise.getGravityValues());
            }
            if (gyroscope)
            {
                features.addAll(exercise.getGyroscopeValues());
            }
            if (magneticField)
            {
                features.addAll(exercise.getMagneticFieldValues());
            }
            if (ambientTemperature)
            {
                features.addAll(exercise.getAmbientTemperatureValues());
            }
            if (light)
            {
                features.addAll(exercise.getLightValues());
            }
            if (pressure)
            {
                features.addAll(exercise.getPressureValues());
            }
            if (relativeHumidity)
            {
                features.addAll(exercise.getRelativeHumidityValues());
            }
            
            String stringFeatures = featuresToString(features);
            if (!stringFeatures.equals(""))
            {
                finalString += stringFeatures + " " + targetForOutput + System.getProperty("line.separator");
            }   
        }
 
        return finalString;
    }
    
    private String featuresToString(ArrayList<Float> features)
    {
        String result = "";
        int counterUsefulValues = 0;
        for (Float element: features)
        {
            if (element != null && !element.isNaN() && !element.isInfinite())
            {
                NumberFormat format = new DecimalFormat("0.#####");
                result += format.format(element) + ",";
                counterUsefulValues++;
            }
            else
            {
                result += "?,";
            }
            
        }
        if (counterUsefulValues != 0)
        {
            return result;
        }
        else
        {
            return "";
        }
    }
}
