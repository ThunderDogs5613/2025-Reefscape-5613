package frc.robot.subsystems.elevator.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.Constants;
import frc.robot.constants.Constants.ElevatorConstants.elevPos;
import frc.robot.subsystems.elevator.ElevatorSubsystem;

public class PositionState extends Command{

    private elevPos position;
    private double holdPosition;


  
    public PositionState(elevPos position) {
      addRequirements(ElevatorSubsystem.getInstance());  
  
      this.position = position;
    }
  
    @Override
    public void initialize() {
  
      holdPosition = ElevatorSubsystem.getInstance().getElevDistance();

      ElevatorSubsystem.enable();

      switch(position) {
        case L1 :
          ElevatorSubsystem.getInstance().setElevSetpoint(Constants.ElevatorConstants.l1);
 //         iArmSubsystem.getInstance().setFeedForward(0.02);
          break;
  
        case L2 :
          ElevatorSubsystem.getInstance().setElevSetpoint(Constants.ElevatorConstants.l2);
//          iArmSubsystem.getInstance().setFeedForward(0.01);
          break;  
          
        case L3 :
          ElevatorSubsystem.getInstance().setElevSetpoint(Constants.ElevatorConstants.l3);
//          iArmSubsystem.getInstance().setFeedForward(0.2);
          break;

        case STOW :
          ElevatorSubsystem.getInstance().setElevSetpoint(Constants.ElevatorConstants.stow);
          break;

        case RECEIVE :
          ElevatorSubsystem.getInstance().setElevSetpoint(Constants.ElevatorConstants.receive);
          break;

        case HOLD :
        holdPosition = ElevatorSubsystem.getInstance().getElevDistance();
        ElevatorSubsystem.getInstance().setElevSetpoint(holdPosition);
//        ArmSubsystem.getInstance().setFeedForward(0.0);
          break;
      }
      ElevatorSubsystem.getInstance().enable();
    }
  
    public void execute() {
      System.out.println(ElevatorSubsystem.getInstance().getElevDistance());
    }
  
    @Override
    public void end(boolean interrupted) {
      ElevatorSubsystem.getInstance().disable();
      ElevatorSubsystem.getInstance().setSpeed(0);
    }
}