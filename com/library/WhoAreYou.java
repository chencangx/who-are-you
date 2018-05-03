package com.library;

import com.sun.jna.Native;
import com.sun.jna.platform.win32.Kernel32;
import com.sun.jna.platform.win32.Tlhelp32;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.platform.win32.WinDef.HWND;
import com.sun.jna.win32.W32APIOptions;

public class WhoAreYou {
  // private static final int MAX_TITLE_LENGTH = 1024;

  public static void main(String[] args) throws Exception {
    // char[] buffer = new char[MAX_TITLE_LENGTH * 2];
    HWND hwnd = new HWND();
    // Kernel32 kernel32 =
    // (Kernel32) Native.loadLibrary(Kernel32.class, W32APIOptions.DEFAULT_OPTIONS);
    IntByReference byReference = new IntByReference();
    int pid = 0;
    while (true) {
      hwnd = User32.INSTANCE.GetForegroundWindow();
      User32.INSTANCE.GetWindowThreadProcessId(hwnd, byReference);
      // User32.INSTANCE.GetWindowText(hwnd, buffer, MAX_TITLE_LENGTH);
      // System.out.print("Active window title: " + Native.toString(buffer));
      if (byReference.getValue() != pid) {
        System.out.println(byReference.getValue());
      }
      pid = byReference.getValue();
      Thread.sleep(100);
    }
  }
}
