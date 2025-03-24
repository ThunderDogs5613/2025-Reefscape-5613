package frc.robot.subsystems.elevator.states;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.constants.Constants;
import frc.robot.subsystems.elevator.ElevatorSubsystem;


public class DownState extends Command {
    
    private ElevatorSubsystem elevator = ElevatorSubsystem.getInstance();

    public DownState() {
        addRequirements(elevator);
    }

    @Override
    public void initialize() {
        elevator.setSpeed(Constants.ElevatorConstants.downSpeed);
    }

}