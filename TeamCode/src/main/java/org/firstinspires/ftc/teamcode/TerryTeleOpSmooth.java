/* Copyright (c) 2017 FIRST. All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without modification,
 * are permitted (subject to the limitations in the disclaimer below) provided that
 * the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice, this list
 * of conditions and the following disclaimer.
 *
 * Redistributions in binary form must reproduce the above copyright notice, this
 * list of conditions and the following disclaimer in the documentation and/or
 * other materials provided with the distribution.
 *
 * Neither the name of FIRST nor the names of its contributors may be used to endorse or
 * promote products derived from this software without specific prior written permission.
 *
 * NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
 * LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
 * THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
 * FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
 * DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

//We're testing this comment

/**
 * This file contains an minimal example of a Linear "OpMode". An OpMode is a 'program' that runs in either
 * the autonomous or the teleop period of an FTC match. The names of OpModes appear on the menu
 * of the FTC Driver Station. When an selection is made from the menu, the corresponding OpMode
 * class is instantiated on the Robot Controller and executed.
 *
 * This particular OpMode just executes a basic Tank Drive Teleop for a two wheeled robot
 * It includes all the skeletal structure that all linear OpModes contain.
 *
 * Use Android Studios to Copy this Class, and Paste it into your team's code folder with a new name.
 * Remove or comment out the @Disabled line to add this opmode to the Driver Station OpMode list
 */

@TeleOp(name="TerryTeleOpSmooth", group="Linear Opmode")
//@Disabled
public class TerryTeleOpSmooth extends LinearOpMode {

    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    private TechbotHardware2 Terry = new TechbotHardware2();


    @Override
    public void runOpMode() {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        System.out.println("Is this thing working?!");
        // Initialize the hardware variables. Note that the strings used here as parameters
        // to 'get' must correspond to the names assigned during the robot configuration
        // step (using the FTC Robot Controller app on the phone).


Terry.init(hardwareMap);
        // Most robots need the motor on one side to be reversed to drive forward
        // Reverse the motor that runs backwards when connected directly to the battery
        //Terry.arm.setDirection(DcMotor.Direction.FORWARD);
        //Terry.servoWrist.setDirection(Servo.Direction.FORWARD);

        /*when controller is pushed forward, Terry moves forward
        left front wheel moves fwd
        left back wheel moves fwd
        right front wheel moves fwd
        right back wheel moves fwd*/

        /*when controller is pushed back, Terry moves back
        left front wheel moves back
        left back wheel moves back
        right front wheel moves back
        right back wheel moves back*/

        /*when controller is pushed left, Terry moves left
        left front wheel moves back
        left back wheel moves fwd
        right front wheel moves fwd
        right back wheel moves back*/

        /*when controller is pushed right, Terry moves right
        left front wheel moves fwd
        left back wheel moves back
        right front wheel moves back
        right back wheel moves fwd*/

        /*when controller is pushed ???, Terry rotates left
        left front wheel moves back
        left back wheel moves back
        right front wheel moves fwd
        right back wheel moves fwd*/

        /*when controller is pushed ???, Terry rotates right
        left front wheel moves fwd
        left back wheel moves fwd
        right front wheel moves back
        right back wheel moves back*/

        //Route 1.  We start to the left on the blue side. Partner moves foundation.
        
        //Route 1.  Move forward. 
        
        //Route 1.  Move right. (under near side of alliance bridge).
        
        //Route 1.  Use color sensor or camera to find black skystone.
        
        //Route 1.  Pick up skystone.
        
        //Route 1.  Move back under alliance bridge. 
        
        //Route 1.  Drop skystone in building zone (doesn't need to be on foundation).
        
        //Route 1.  Use color sensor to park under alliance bridge.

        
        //Route 2.  We start to the left on the blue side. We move foundation.
        
        //Route 2.  Move forward and left to foundation.
        
        //Route 2.  Grab foundation with arm.
        
        //Route 2.  Drag foundation into corner with triangle by moving backwards.
        
        //Route 2.  Move right until in front of skystones.
        
        //Route 2.  Move forward 2 skystones.
        
        //Route 2.  Use color sensor or camera to find black skystone.
        
        //Route 2.  Pick up skystone

        //Route 2.  Move back under alliance bridge.

        //Route 2.  Drop skystone in building zone (doesn't need to be on foundation).

        //Route 2.  Use color sensor to park under alliance bridge.


        //Route 3.  We start to the right on the blue side. Partner moves foundation.

        //Route 3.  Move forward and slightly right, in front of skystones. 

        //Route 3.  Use color sensor or camera to find black skystone.

        //Route 3.  Pick up skystone.
        
        //Route 3.  Move back under alliance bridge. 

        //Route 3.  Drop skystone in building zone (doesn't need to be on foundation).

        //Route 3.  Use color sensor to park under alliance bridge.


        
        //Route 4.  We start to the right on the blue side. We move foundation.

        //Route 4.  Move right until in front of skystones.

        //Route 4.  Move forward 2 skystones.

        //Route 4.  Use color sensor or camera to find black skystone.

        //Route 4.  Pick up skystone

        //Route 4.  Move back under alliance bridge.

        //Route 4.  Drop skystone on foundation. 
        
        //Route 4.  Move forward and left to foundation.

        //Route 4.  Grab foundation with arm.

        //Route 4.  Drag foundation into building zone by moving backwards.

        //Route 4.  Use color sensor to park under alliance bridge.



        //Route 5 (similar to 3).  We start to the left on the red side. Partner moves foundation.

        //Route 5 (3).  Move forward and slightly left, in front of skystones.

        //Route 5 (3).  Use color sensor or camera to find black skystone.

        //Route 5 (3).  Pick up skystone.

        //Route 5 (3).  Move back under alliance bridge.

        //Route 5 (3).  Drop skystone in building zone (doesn't need to be on foundation).

        //Route 5 (3).  Use color sensor to park under alliance bridge.



        //Route 6 (similar to 4).  We start to the left on the red side. We move foundation.

        //Route 6 (4).  Move forward and left until in front of skystones.

        //Route 6 (4).  Move forward 2 skystones.

        //Route 6 (4).  Use color sensor or camera to find black skystone.

        //Route 6 (4).  Pick up skystone.

        //Route 6 (4).  Move back under alliance bridge.

        //Route 6 (4).  Drop skystone on foundation.

        //Route 6 (4).  Move forward and left to foundation.

        //Route 6 (4).  Grab foundation with arm.

        //Route 6 (4).  Drag foundation into building zone by moving backwards.

        //Route 6 (4).  Use color sensor to park under alliance bridge.


        //Route 7 (similar to 1).  We start to the right on the red side. Partner moves foundation.

        //Route 7 (1).  Move forward.

        //Route 7 (1).  Move right. (under near side of alliance bridge).

        //Route 7 (1).  Use color sensor or camera to find black skystone.

        //Route 7 (1).  Pick up skystone.

        //Route 7 (1).  Move back under alliance bridge.

        //Route 7 (1).  Drop skystone in building zone (doesn't need to be on foundation).

        //Route 7 (1).  Use color sensor to park under alliance bridge.



        //Route 8 (similar to 2).  We start to the right on the red side. We move foundation.

        //Route 8 (2).  Move forward and right to foundation.

        //Route 8 (2).  Grab foundation with arm.

        //Route 8 (2).  Drag foundation into corner with triangle by moving backwards.

        // Route 8 (2).  Move left until in front of skystones.

        //Route 8 (2).  Move forward 2 skystones.

        //Route 8 (2).  Use color sensor or camera to find black skystone.

        //Route 8 (2).  Pick up skystone

        //Route 8 (2).  Move back under alliance bridge.

        //Route 8 (2).  Drop skystone in building zone (doesn't need to be on foundation).

        //Route 8 (2).  Use color sensor to park under alliance bridge.







        // Wait for the game to start (driver presses PLAY)
        waitForStart();
        runtime.reset();

        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            // Setup a variable for each drive wheel to save power level for telemetry
           /* double leftPower;
            double rightPower;
            double leftBackPower;
            double rightBackPower;*/
            //double armPower;
            double handPosition;
            //double wristPosition;
            double slidePower;
            double drivePower;
            double spinPowerCCW;
            double slideSpower;
            double spinPowerCW;
            double larmPower;
            double farmPower;
            double driveSPower;
            //double dragPosition=.5;

            // Tank Mode uses one stick to control each wheel.
            // - This requires no math, but it is hard to drive forward slowly and keep straight.

            /*leftPower  = gamepad1.right_stick_y ;
            rightPower = gamepad1.right_stick_y ;
            leftBackPower = gamepad1.right_stick_y;
            rightBackPower = gamepad1.right_stick_y;*/
            //armPower = gamepad2.left_stick_y;
            handPosition = gamepad2.right_trigger;
            slidePower = gamepad1.right_stick_x;
            drivePower = gamepad1.right_stick_y;
            driveSPower = gamepad1.left_stick_y;
            spinPowerCCW = gamepad1.right_trigger;
            slideSpower = gamepad1.left_stick_x;
            spinPowerCW = -gamepad1.left_trigger;
            larmPower = -gamepad2.left_stick_y;
            farmPower = gamepad2.right_stick_y;

            if (gamepad2.a == true) {
                Terry.fervoL.setPosition(0);
                Terry.fervoR.setPosition(0);
            } else {
                Terry.fervoL.setPosition(0.5);
                Terry.fervoR.setPosition(0.5);
            }

            if (gamepad1.x == true) {
                Terry.farm.setPower(0.15);
            } else if (gamepad1.y == true) {
                Terry.farm.setPower(-0.3);
            } else {
                Terry.farm.setPower(0);
            }

            //wristPosition = gamepad2.left_trigger;

            // Send calculated power to wheels
            /*Terry.leftDrive.setPower(leftPower);
            Terry.rightDrive.setPower(rightPower);
            Terry.leftBackDrive.setPower(leftBackPower);
            Terry.rightBackDrive.setPower(rightBackPower);*/
            Terry.larm.setPower(larmPower / 3);
            //Terry.farm.setPower(farmPower / 4);
            Terry.servoHand.setPosition(0.00 + handPosition);
            //Terry.servoWrist.setPosition(0.00+wristPosition);
            if (gamepad1.right_stick_x > 0.2 || (gamepad1.right_stick_x < -0.2)) {
                Terry.slideL(slidePower / 2);
            } else if (gamepad1.right_stick_y > 0.2 || (gamepad1.right_stick_y < -0.2)) {
                Terry.drive(drivePower / 2);
            } else if (gamepad1.right_trigger > 0.2 || (gamepad1.right_trigger < -0.2)) {
                Terry.spin(spinPowerCCW / 2);
            } else if (gamepad1.left_stick_x > 0.2 || (gamepad1.left_stick_x < -0.2)) {
                Terry.slideS(slideSpower / 2);
            } else if (gamepad1.left_trigger > 0.2 || (gamepad1.left_trigger < -0.2)) {
                Terry.spin(spinPowerCW / 2);
            } else if (gamepad1.left_stick_y > 0.2 || (gamepad1.left_stick_y < -0.2)) {
                Terry.driveS(driveSPower);
            }

            else {
                Terry.drive(0);
                Terry.slideL(0);
                Terry.spin(0);
                Terry.spin(0);
                Terry.driveS(0);
                Terry.slideS(0);
            }


            Terry.leftDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            Terry.rightDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            Terry.leftBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
            Terry.rightBackDrive.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);

            // Show the elapsed game time and wheel power.
            //telemetry.addData("Status", "Run Time: " + runtime.toString());
           // telemetry.addData("Motors", "left (%.2f), right (%.2f)", Terry.leftDrive, Terry.rightDrive, /*armPower, */Terry.leftBackDrive, Terry.rightBackDrive);
            /*telemetry.addData("Servo Position", "%5.2f", handPosition/*, wristPosition);*/
            //telemetry.update();
        }
    }
}