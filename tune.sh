# All ideas come from:
# http://wiki.eclipse.org/Jetty/Howto/High_Load

sudo sysctl -w net.core.somaxconn=4096
sudo sysctl -w net.core.netdev_max_backlog=16384
sudo sysctl -w net.ipv4.tcp_max_syn_backlog=8192
sudo sysctl -w net.ipv4.tcp_syncookies=1

# Set user limits correctly in /etc/security/limits.conf
#yossi		hard	nofile		100000
#yossi		soft	nofile		100000

# Set Acceptors to number of cores (in VB case = 1)
# file: /etc/jetty8/jetty.xml
# <Set name="Acceptors">1</Set>

# Set in /etc/default/jetty8
# JAVA_OPTIONS="-server -Xms128m -Xmx384m"  

# Test
