package frc.robot.subsystems.outtake.States;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.outtake.OuttakeSubsystem;


public class NoMoveState extends Command {
    
    private OuttakeSubsystem outtake = OuttakeSubsystem.getInstance();

    public NoMoveState() {
        addRequirements(outtake);
    }

    @Override
    public void initialize() {
        outtake.setSpeed(0);
    }

}