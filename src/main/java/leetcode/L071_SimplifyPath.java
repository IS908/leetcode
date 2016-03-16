package leetcode;

import java.util.Stack;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 * <p/>
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 * <p/>
 * Created by kevin on 2016/3/16.
 */
public class L071_SimplifyPath {
    public String simplifyPath(String path) {
        if (path == null) return null;
        Stack<String> stack = new Stack<>();
        String[] strs = path.split("/");
        for (int i = 0; i < strs.length; i++) {
            switch (strs[i]) {
                case ".":
                case "":
                    break;
                case "..":
                    if (!stack.empty()) stack.pop();
                    break;
                default:
                    stack.push(strs[i]);
                    break;
            }
        }
        StringBuilder sb = new StringBuilder();
        if (stack.empty())  return "/";
        while (!stack.empty()) {
            sb.insert(0, "/" + stack.pop());
        }
        return sb.toString();
    }
}
