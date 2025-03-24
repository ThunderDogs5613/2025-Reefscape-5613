package frc.robot.subsystems.elevator.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.elevator.ElevatorSubsystem;

public class PrintState extends Command {

  public static double position;

  public PrintState() {
    addRequirements(ElevatorSubsystem.getInstance());

  }


  @Override
  public void initialize() {
    //ArmSubsystem.getInstance().setPower(0);
    System.out.println("initialize print Statementy");
  }


  @Override
  public void execute() {
    position = ElevatorSubsystem.getInstance().getElevDistance();
    System.out.println(position);
  }


  @Override
  public void end(boolean interrupted) {}


  @Override
  public boolean isFinished() {
    return false;
  }
}