import java.nio.file.*;
import java.net.*;
import java.io.IOException;

public class RelativizePrac {
	public static void main(String... args) throws URISyntaxException {
		Path p1 = Paths.get("x\\y");
		Path p2 = Paths.get("z");
		Path p3 = p1.relativize(p2);
		System.out.println(p3);
	}
	/**
	* What does p3 print?
	* 
	* a. x\y\z
	* Observe what happens when you append this path to p1:
	*   x\y +\x\y\z =>x\y\x\y\z  
	* This is not same as z
	*
	* b. \z
	* Observe what happens when you append this path to p1:
	*   x\y + \z =>x\y\z
	*  This is not same as z
	*
	* c. ..\z
	* Observe what happens when you append this path to p1:
	*   x\y + ..\z =>x\z
	*  This is not same as z
	*
	* d. ..\..\z
	* Observe what happens when you append this path to p1:
	*   x\y + ..\..\z =>x + ..\z =>z
	*  This is what we want. So this is the correct answer.
	*  A ".." implies parent folder, therefore imagine that 
	* you are taking off one ".." from the right side of the plus sign
	* and removing the last name of the path on the left side of the plus sign.
	* For example, .. appended to y makes it y\.., which cancels out.
	*
	* Explanation:
	* You need to understand how relativize works for the purpose of the exam. 
	* The basic idea of relativize is to determine a path, which, when applied 
	* to the original path will give you the path that was passed. For example, 
	* "a/c" relativize "a/b"  is "../b" because "/a/c/../b" is "/a/b" Notice that  
	* "c/.." cancel out. 
	*
	* Please go through the following description of relativize() method, 
	* which explains how it works in more detail.
	*
	* public Path relativize(Path other)
	* Constructs a relative path between this path and a given path. 
	* Relativization is the inverse of resolution. This method attempts to 
	* construct a relative path that when resolved against this path, 
	* yields a path that locates the same file as the given path. 
	* For example, on UNIX, if this path is "/a/b" and the given path is 
	* "/a/b/c/d" then the resulting relative path would be "c/d". 
	*
	* Where this path and the given path do not have a root component, 
	* then a relative path can be constructed. 
	*
	* A relative path cannot be constructed if only one of the paths have a root component. 
	*
	* Where both paths have a root component then it is implementation dependent if a 
	* relative path can be constructed. 
	*
	* If this path and the given path are equal then an empty path is returned.
	*
	* For any two normalized paths p and q, where q does not have a root component,
	* p.relativize(p.resolve(q)).equals(q)
	*
	* When symbolic links are supported, then whether the resulting path, 
	* when resolved against this path, yields a path that can be used to locate 
	* the same file as other is implementation dependent. 
	* For example, if this path is "/a/b" and the given path is "/a/x" 
	* then the resulting relative path may be "../x". If "b" is a symbolic link 
	* then is implementation dependent if "a/b/../x" would locate the same file as "/a/x".
	*
	*/
}