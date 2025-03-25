package frc.robot.subsystems.outtake;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.constants.RobotMap;
import com.revrobotics.spark.*;
import com.revrobotics.spark.SparkLowLevel.MotorType;

public class OuttakeSubsystem extends SubsystemBase {
  
  private static OuttakeSubsystem instance;
  private SparkMax motorOT;

  private OuttakeSubsystem() {
    motorOT = new SparkMax(RobotMap.OUTTAKE_MOTOR_ID, MotorType.kBrushless);
  }

  public static OuttakeSubsystem getInstance() {
    if (instance == null){
      instance = new OuttakeSubsystem();
    }
    return instance;
  }
  public void setSpeed(double speed) {
  motorOT.set(speed);
  }
  
  @Override
  public void periodic() {} 
}