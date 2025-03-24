package frc.robot.subsystems.elevator;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import com.revrobotics.spark.*;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class ElevatorSubsystem extends SubsystemBase {
  
  private static ElevatorSubsystem instance;
  private SparkMax motorEL;
  private SparkMax motorER;
  private Encoder encoder;

  private ElevatorSubsystem() {
    motorEL = new SparkMax(RobotMap.ELEV_LEFT_MOTOR_ID, MotorType.kBrushless);
    motorER = new SparkMax(RobotMap.ELEV_RIGHT_MOTOR_ID, MotorType.kBrushless);
  }

  public static ElevatorSubsystem getInstance() {
    if (instance == null){
      instance = new ElevatorSubsystem();
    }
    return instance;
  }
  public void setSpeed(double speed) {
  motorEL.set(speed);
  }

  public double getElevDistance() {
    return encoder.getDistance();
  }
  
  @Override
  public void periodic() {} 
}