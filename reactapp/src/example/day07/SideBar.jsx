import * as React from 'react';
import Box from '@mui/joy/Box';
import List from '@mui/joy/List';
import ListItem from '@mui/joy/ListItem';
import ListItemButton, { listItemButtonClasses } from '@mui/joy/ListItemButton';
import IconButton from '@mui/joy/IconButton';
import Typography from '@mui/joy/Typography';
import ReceiptLong from '@mui/icons-material/ReceiptLong';
import KeyboardArrowDown from '@mui/icons-material/KeyboardArrowDown';

export default function SideBar(props){
    
    const [open, setOpen] = React.useState(false);
    const [open2, setOpen2] = React.useState(false);
    return(<>
    <Box sx={{ width: 320, pl: '24px' }}>
      <List
        size="sm"
        sx={(theme) => ({
          // Gatsby colors
          '--joy-palette-primary-plainColor': '#8a4baf',
          '--joy-palette-neutral-plainHoverBg': 'transparent',
          '--joy-palette-neutral-plainActiveBg': 'transparent',
          '--joy-palette-primary-plainHoverBg': 'transparent',
          '--joy-palette-primary-plainActiveBg': 'transparent',
          [theme.getColorSchemeSelector('dark')]: {
            '--joy-palette-text-secondary': '#635e69',
            '--joy-palette-primary-plainColor': '#d48cff',
          },
          '--List-insetStart': '32px',
          '--ListItem-paddingY': '0px',
          '--ListItem-paddingRight': '16px',
          '--ListItem-paddingLeft': '21px',
          '--ListItem-startActionWidth': '0px',
          '--ListItem-startActionTranslateX': '-50%',
          [`& .${listItemButtonClasses.root}`]: {
            borderLeftColor: 'divider',
          },
          [`& .${listItemButtonClasses.root}.${listItemButtonClasses.selected}`]: {
            borderLeftColor: 'currentColor',
          },
          '& [class*="startAction"]': {
            color: 'var(--joy-palette-text-tertiary)',
          },
        })}
      >
        <ListItem nested>
          <ListItem component="div" startAction={<ReceiptLong />}>
            <Typography level="body-xs" sx={{ textTransform: 'uppercase' }}>
              무브온 : 생활정보통합 플랫폼
            </Typography>
          </ListItem>
          <List sx={{ '--List-gap': '0px' }}>
            <ListItem>
              <ListItemButton selected> 생활 </ListItemButton>
            </ListItem>
          </List>
        </ListItem>
        <ListItem sx={{ '--List-gap': '0px' }}>
          <ListItemButton> 안전 </ListItemButton>
        </ListItem>
        <ListItem sx={{ '--List-gap': '0px' }}>
          <ListItemButton> 교통 </ListItemButton>
        </ListItem>
        <ListItem sx={{ '--List-gap': '0px' }}>
          <ListItemButton> 커뮤니티 </ListItemButton>
        </ListItem>
        <ListItem
          nested
          sx={{ my: 1 }}
          startAction={
            <IconButton
              variant="plain"
              size="sm"
              color="neutral"
              onClick={() => setOpen(!open)}
            >
              <KeyboardArrowDown
                sx={[
                  open ? { transform: 'initial' } : { transform: 'rotate(-90deg)' },
                ]}
              />
            </IconButton>
          }
        >
          <ListItem>
            <Typography
              level="inherit"
              sx={[
                open
                  ? { fontWeight: 'bold', color: 'text.primary' }
                  : { fontWeight: null, color: 'inherit' },
              ]}
            >
              Tutorial
            </Typography>
            <Typography component="span" level="body-xs">
              9
            </Typography>
          </ListItem>
          {open && (
            <List sx={{ '--ListItem-paddingY': '8px' }}>
              <ListItem>
                <ListItemButton> 생활 </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>
                  0. 공과금정산
                </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>
                  1. 쓰레기배출정보
                </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>2. 의류수거함 지도 </ListItemButton>
                </ListItem>
              <ListItem>
                <ListItemButton>
                  3. 전동휠체어 충전소
                </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>
                  4. 공영주차장
                </ListItemButton>
              </ListItem>
            </List>
          )}
        </ListItem>
        <ListItem
          nested
          sx={{ my: 1 }}
          startAction={
            <IconButton
              variant="plain"
              size="sm"
              color="neutral"
              onClick={() => setOpen2((bool) => !bool)}
            >
              <KeyboardArrowDown
                sx={[
                  open2 ? { transform: 'initial' } : { transform: 'rotate(-90deg)' },
                ]}
              />
            </IconButton>
          }
        >
          <ListItem>
            <Typography
              level="inherit"
              sx={[
                open2
                  ? { fontWeight: 'bold', color: 'text.primary' }
                  : { fontWeight: null, color: 'inherit' },
              ]}
            >
              마이 무브온
            </Typography>
            <Typography component="span" level="body-xs">
              39
            </Typography>
          </ListItem>
          {open2 && (
            <List sx={{ '--ListItem-paddingY': '8px' }}>
              <ListItem>
                <ListItemButton> 공과금 정산내역 </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>나의 소분모임 </ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>찜한 지역행사</ListItemButton>
              </ListItem>
              <ListItem>
                <ListItemButton>문의내역</ListItemButton>
              </ListItem>
            </List>
          )}
        </ListItem>
      </List>
    </Box>
    </>)
}