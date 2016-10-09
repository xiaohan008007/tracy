/**
 * 
 */
package CPU_GC.JVM;

/**
 * @author tracy.lu
 * @date:2015年11月12日 上午10:14:21
 * @version :
 */
public class TestHeap {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // byte[] b1 = new byte[1024 * 1024 / 2];
        // byte[] b2 = new byte[1024 * 1024 * 8];
        // b2 = null;
        // b2 = new byte[1024 * 1024 * 8];
        // System.gc();

        for (int i = 0; i < Integer.MAX_VALUE; i++) {
            String t = String.valueOf(i).intern();
        }
    }
    // Heap
    // PSYoungGen total 18432K, used 9359K [0x00000000fec00000, 0x0000000100000000, 0x0000000100000000)
    // eden space 16384K, 57% used [0x00000000fec00000,0x00000000ff523e10,0x00000000ffc00000)
    // from space 2048K, 0% used [0x00000000ffe00000,0x00000000ffe00000,0x0000000100000000)
    // to space 2048K, 0% used [0x00000000ffc00000,0x00000000ffc00000,0x00000000ffe00000)
    // PSOldGen total 20480K, used 8192K [0x00000000fd800000, 0x00000000fec00000, 0x00000000fec00000)
    // object space 20480K, 40% used [0x00000000fd800000,0x00000000fe000010,0x00000000fec00000)
    // PSPermGen total 21248K, used 3032K [0x00000000f8600000, 0x00000000f9ac0000, 0x00000000fd800000)
    // object space 21248K, 14% used [0x00000000f8600000,0x00000000f88f63a8,0x00000000f9ac0000)

}
