package frc.robot.commands;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;
import frc.robot.subsystems.ShooterSubsystem;

public class ShooterCommand extends CommandBase {
    private final ShooterSubsystem m_shooterSubsystem;

    public ShooterCommand(ShooterSubsystem m_shooterSubsystem) {
        this.m_shooterSubsystem = m_shooterSubsystem;

        addRequirements(m_shooterSubsystem);
    }
    
    @Override
    public void execute() {
        //todo uncomment when color sensor in use
        // this will spit the ball out nicely if the ball color does not match alliance color
        // if (Robot.getColorSensor().hasBall()) {
        //     if (Robot.getColorSensor().isRedBall() && DriverStation.getAlliance() != DriverStation.Alliance.Red
        //         || Robot.getColorSensor().isBlueBall() && DriverStation.getAlliance() != DriverStation.Alliance.Blue) {
        //         m_shooterSubsystem.drive(0.1, 0.1);
        //         //todo activate servo?
        //         return;
        //     }
        // }

        m_shooterSubsystem.drive(1.0, -1.0);
        //todo activate servo?
    }

     /**
     * @param interrupted
     */
    @Override
    public void end(boolean interrupted) {
        m_shooterSubsystem.drive(0.0, 0.0);
    }
}
