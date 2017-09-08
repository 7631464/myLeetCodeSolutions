public class Solution {
    public String simplifyPath(String path) {
        StringBuffer res=new StringBuffer();
        List<String> temp=new ArrayList<String>();
        int i=0, j=0;
        int currpos=-1;
        int len=path.length();
        for (i=0; i<=len; i++) {
            if (i==len || path.charAt(i)=='/') {
                if (path.substring(j,i).equals("..")) {if (currpos>-1) currpos--;}
                else if (i>j && !path.substring(j,i).equals(".") ) {
                    currpos++;
                    if (currpos==temp.size()) temp.add(path.substring(j,i));
                    else temp.set(currpos,path.substring(j,i) );
                }
                j=i+1;
            }
        }
        for (i=0; i<=currpos; i++) {
            res.append('/');
            res.append(temp.get(i));
        }
        if (res.length()==0) res.append('/');
        return res.toString();
    }
}
