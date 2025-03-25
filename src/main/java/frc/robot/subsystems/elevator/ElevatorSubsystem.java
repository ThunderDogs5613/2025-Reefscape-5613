package frc.robot.subsystems.elevator;

import com.revrobotics.spark.*;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import frc.robot.constants.Constants;
import frc.robot.constants.RobotMap;
import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.DutyCycleEncoder;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ElevatorSubsystem extends SubsystemBase {
    private static boolean isUsingPID = false;
    private SparkMax motorEL, motorER;
    private Encoder encoder;
    private PIDController elevPID = new PIDController(Constants.ElevatorConstants.kP, Constants.ElevatorConstants.kI, Constants.ElevatorConstants.kD);

    private static ElevatorSubsystem instance;

    private ElevatorSubsystem() {
      motorEL = new SparkMax(RobotMap.ELEV_LEFT_MOTOR_ID, MotorType.kBrushless);
      motorER = new SparkMax(RobotMap.ELEV_RIGHT_MOTOR_ID, MotorType.kBrushless);
    }

    public static synchronized ElevatorSubsystem getInstance() {
        if(instance == null){
          instance = new ElevatorSubsystem();
        }
        return instance;
    }
    
    public void setSpeed(double power) {
      motorEL.set(power);
    }

    protected double getMeasurement() {
      return getElevDistance();
    } 

    public double getElevDistance() {
      return encoder.getDistance();
      //return encoder.getPosition();
    }
    
    public static void enable() {
      isUsingPID = true;
    }

    public void disable() {
      isUsingPID = false;
    }

    public void setElevSetpoint(double setpoint) {
      elevPID.setSetpoint(setpoint);
    }

    public double getElevSetpoint() {
      return elevPID.getSetpoint();
    }
    
    public void periodic() {
      if(isUsingPID) {
        setSpeed(elevPID.calculate(getMeasurement()));
      }
    }
}