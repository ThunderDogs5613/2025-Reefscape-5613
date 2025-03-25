package frc.robot.constants;

public final class Constants {
    
    public final class ElevatorConstants {
        public static final double upSpeed = 0.35;
        public static final double downSpeed = 0.25;
        public static final double feedForward = 0.02;

        public static final double kP = 0.2;
        public static final double kI = 0.0;
        public static final double kD = 0.0;

        public static final double stow = 0;
        public static final double receive = 0;
        public static final double l1 = 0;
        public static final double l2 = 0;
        public static final double l3 = 0;
        public enum elevPos {
            STOW, RECEIVE, L1, L2, L3, HOLD
        }
    }
}
